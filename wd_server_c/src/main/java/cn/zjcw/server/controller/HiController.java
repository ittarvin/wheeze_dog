package cn.zjcw.server.controller;



import cn.zjwc.structlog4j.ILogger;
import cn.zjwc.structlog4j.SLoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    private ILogger log = SLoggerFactory.getLogger(HiController.class);


    @RequestMapping("/c")
    public String sayHi(@RequestBody String body) {

        log.info("param","body",body);

        return " CServerReceived " + body;
    }

}
