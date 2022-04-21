package cn.zjcw.zipkin.kafka.spring.boot;


import cn.zjcw.zipkin.kafka.spring.config.ZipkinKafkaProperties;
import cn.zjcw.zipkin.kafka.spring.config.ZipkinKafkaPropertySourcesConstants;
import cn.zjcw.zipkin.kafka.spring.sender.ZipKinKafkaSender;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;


/**
 * zipkin2kafka 插件自动配置项
 * <p>
 *     Spring Cloud Sleuth supports sending traces to multiple tracing systems as of version 2.1.0
 * @author Arvin
 * @since 2022-04-13
 */
@Configuration
@ConditionalOnProperty({
        ZipkinKafkaPropertySourcesConstants.ZIPKIN_KAFKA_BOOTSTRAP_ENABLED,
        ZipkinKafkaPropertySourcesConstants.SPRING_ZIPKIN_BOOTSTRAP_ENABLED})
@EnableApolloConfig
public class ZipKinKafkaAutoConfiguration {


    @Autowired
    ZipkinKafkaProperties zipkinKafkaProperties;

    @Bean(ZipkinKafkaPropertySourcesConstants.REPORTER_BEAN_NAME)
    Reporter<Span> zipkinKafkaReporter() {
        return AsyncReporter.create(zipKinKafkaSender());
    }

    @Bean(ZipkinKafkaPropertySourcesConstants.SENDER_BEAN_NAME)
    ZipKinKafkaSender zipKinKafkaSender() {
        return ZipKinKafkaSender.newBuilder()
                .bootstrapServers(zipkinKafkaProperties.getBootstrapServers())
                .topic(zipkinKafkaProperties.getTopic()).build();
    }

}
