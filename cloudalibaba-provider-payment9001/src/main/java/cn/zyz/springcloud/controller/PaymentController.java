package cn.zyz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2020
 * @author: zyz
 * @create: 2022-06-18 19:21
 **/


@RestController
public class PaymentController {

    @Value("${server.port}")
    String port;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id){
        return "nacos registry, serverPort:"+port+"\t"+id;
    }
}



