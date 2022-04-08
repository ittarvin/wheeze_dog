package cn.zjcw.server.controller;


import cn.zjcw.server.client.Client2c;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    @Autowired
    private Client2c client2c;


    @RequestMapping("/b")
    public String sayHi(@RequestParam("name") String name) {

        return client2c.sayHi(name);

    }

}
