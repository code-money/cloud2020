package cn.zyz.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @author: zyz
 * @create: 2022-07-31 22:31
 **/

@RestController
public class OrderNacosController {

    public static final String PAYMENT_URL="http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/nacos/"+id,String.class);
    }

}



