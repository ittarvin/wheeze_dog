
package cn.zjcw.server;


import cn.zjcw.server.config.SampleRedisConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "cn.zjcw")
@EnableAutoConfiguration
@EnableApolloConfig
public class Application {

    @Bean
    public SampleRedisConfig sampleRedisConfig() {
        return new SampleRedisConfig();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

}
