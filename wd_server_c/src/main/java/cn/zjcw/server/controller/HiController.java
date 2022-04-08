package cn.zjcw.server.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {




    @RequestMapping("/c")
    public String sayHi(@RequestParam("name") String name) {
        return "Hi" + name;
    }

}
