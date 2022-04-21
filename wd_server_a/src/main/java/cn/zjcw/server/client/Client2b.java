package cn.zjcw.server.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wdSleuthServerB")
public interface Client2b {

    @RequestMapping(method = RequestMethod.POST, value = "/b")
    String sayHi(@RequestBody String body);
}
