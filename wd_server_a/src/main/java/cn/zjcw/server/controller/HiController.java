package cn.zjcw.server.controller;

import cn.zjcw.server.client.Client2b;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    @Autowired
    private Client2b client2b;


    @RequestMapping("/a")
    public String sayHi(@RequestParam("name") String name) {

        return client2b.sayHi(name);

    }

}
