package cn.zjcw.server.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("wdSleuthServerC")
public interface Client2c {

    @RequestMapping("/c")
    String sayHi(@RequestBody String bod);

}
