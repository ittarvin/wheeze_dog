package cn.zjcw.server.controller;


import cn.zjcw.server.client.Client2c;
import cn.zjwc.structlog4j.ILogger;
import cn.zjwc.structlog4j.SLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    private ILogger log = SLoggerFactory.getLogger(HiController.class);

    @Autowired
    private Client2c client2c;


    @RequestMapping("/b")
    public String sayHi(@RequestBody String body) {

        String result = client2c.sayHi(body);

        log.info("param","body",body,"CServerReturn",result);

        return result;

    }

}
