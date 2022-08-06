package cn.zyz.springcloud.controller;


import cn.zyz.springcloud.entity.CommonResult;
import cn.zyz.springcloud.entity.Payment;
import cn.zyz.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @RequestMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        CommonResult<Payment> paymentCommonResult = paymentFeignService.selectById(id);
        return paymentCommonResult;
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        String serverPort = paymentFeignService.paymentFeignTimeout();

        return serverPort;
    }
}
