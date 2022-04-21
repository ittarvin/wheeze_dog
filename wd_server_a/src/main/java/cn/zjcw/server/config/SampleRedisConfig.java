package cn.zjcw.server.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "test")
@RefreshScope
@ConditionalOnProperty("test")
public class SampleRedisConfig {

    private String 	a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
