package cn.zyz.springcloud.controller;


import cn.zyz.springcloud.entity.CommonResult;
import cn.zyz.springcloud.entity.Payment;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class OrderController {
//    public static final String PAYMENT_URL= "http://localhost:8001";
    public static final String PAYMENT_URL= "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate template;

    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return template.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectById(@PathVariable("id") Long id){
        return template.getForObject(PAYMENT_URL + "/payment/get/"+id, CommonResult.class);
    }

    @RequestMapping("/getServicesList")
    public Object getServicesList() {
        List<List<ServiceInstance>> servicesList = new ArrayList<>();
        //获取服务名称
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames)  {
            //获取服务中的实例列表
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            servicesList.add(serviceInstances);
        }
        return servicesList;
    }
}
