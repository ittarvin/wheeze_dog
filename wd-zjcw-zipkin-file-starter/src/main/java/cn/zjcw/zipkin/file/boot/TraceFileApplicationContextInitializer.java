package cn.zjcw.zipkin.file.boot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;


/**
 * zipkin2file 插件启动监听
 * @author Arvin
 * @since 2022-04-21
 */
public class TraceFileApplicationContextInitializer implements  ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(TraceFileApplicationContextInitializer.class);

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;

    private int order = DEFAULT_ORDER;

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

        if (!environment.getProperty(TraceFilePropertySourcesConstants.ZIPKIN_FILE_BOOTSTRAP_ENABLED, Boolean.class, false)) {
            logger.debug("Zipkin 2 File bootstrap config is not enabled for context {}, see property: ${{}}",
                    configurableApplicationContext, TraceFilePropertySourcesConstants.ZIPKIN_FILE_BOOTSTRAP_ENABLED);
            return;
        }

        logger.debug("Zipkin 2 File bootstrap config is enabled for context {}", configurableApplicationContext);

    }


    @Override
    public int getOrder() {
        return order;
    }

}
