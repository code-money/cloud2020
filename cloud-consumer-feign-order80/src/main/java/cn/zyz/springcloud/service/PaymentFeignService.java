package cn.zyz.springcloud.service;


import cn.zyz.springcloud.entity.CommonResult;
import cn.zyz.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//指定调用的微服务名称
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}") //此处是代理路径，记得写全路径  /payment别忘记写
    CommonResult<Payment> selectById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
