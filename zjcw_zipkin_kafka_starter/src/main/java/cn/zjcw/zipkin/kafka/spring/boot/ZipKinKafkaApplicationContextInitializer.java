package cn.zjcw.zipkin.kafka.spring.boot;
import cn.zjcw.zipkin.kafka.spring.config.ZipkinKafkaPropertySourcesConstants;
import cn.zjwc.structlog4j.StructLog4J;
import cn.zjwc.structlog4j.json.JsonFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;


/**
 * zipkin2kafka 插件启动监听
 * @author Arvin
 * @since 2022-04-13
 */
public class ZipKinKafkaApplicationContextInitializer implements  ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(ZipKinKafkaApplicationContextInitializer.class);

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;

    private int order = DEFAULT_ORDER;

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

        if (!environment.getProperty(ZipkinKafkaPropertySourcesConstants.ZIPKIN_KAFKA_BOOTSTRAP_ENABLED, Boolean.class, false)) {
            logger.debug("Zipkin 2 Kafka bootstrap config is not enabled for context {}, see property: ${{}}",
                    configurableApplicationContext, ZipkinKafkaPropertySourcesConstants.ZIPKIN_KAFKA_BOOTSTRAP_ENABLED);
            return;
        }

        logger.debug("Zipkin 2 Kafka bootstrap config is enabled for context {}", configurableApplicationContext);

        if (!environment.getProperty(ZipkinKafkaPropertySourcesConstants.STRUCT_LOGGER_ENABLED, Boolean.class, false)) {

            logger.debug("Struct log4j config is not enabled for context {}, see property: ${{}}",
                    configurableApplicationContext, ZipkinKafkaPropertySourcesConstants.STRUCT_LOGGER_ENABLED);

            return;

        }else{

            logger.debug("Struct log4j config is  enabled for context {}", configurableApplicationContext);

            // JSON 格式输出
            StructLog4J.setFormatter(JsonFormatter.getInstance());
        }

    }


    @Override
    public int getOrder() {
        return order;
    }

}
