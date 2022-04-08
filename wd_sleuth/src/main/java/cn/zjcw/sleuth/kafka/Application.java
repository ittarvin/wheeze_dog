package cn.zjcw.sleuth.kafka;

import cn.zjwc.structlog4j.ILogger;
import cn.zjwc.structlog4j.SLoggerFactory;
import cn.zjwc.structlog4j.StructLog4J;
import cn.zjwc.structlog4j.json.JsonFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.SpanAdjuster;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "cn.zjcw")
public class Application {

    private ILogger log = SLoggerFactory.getLogger(Application.class);

    @Value("${spring.profiles.active:NA}")
    private String activeProfile;

    @Value("${spring.application.name:NA}")
    private String appName;

    @RequestMapping("/")
    @NewSpan(name = "customNameOnTestMethod3")
    public String home() {

        log.info("","data","Hello World");

        return "Hello World";
    }


    @PostConstruct
    public void init() {
        StructLog4J.setFormatter(JsonFormatter.getInstance());
        StructLog4J.setMandatoryContextSupplier(() -> new Object[]{
                "active", activeProfile,
                "appName",appName});
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
