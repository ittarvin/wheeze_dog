package cn.zjcw.server.controller;




import cn.zjcw.server.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {



    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/d")
    public String sayHi(@RequestBody String body) {

        logger.info("param => {}",body);

        return " DServerReceived " + body;
    }


}
