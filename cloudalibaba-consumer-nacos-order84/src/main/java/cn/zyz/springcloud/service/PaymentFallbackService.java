package cn.zyz.springcloud.service;

import cn.zyz.springcloud.entity.CommonResult;
import cn.zyz.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @program: cloud2020
 * @author: zyz
 * @create: 2022-08-04 12:35
 **/

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，----PaymentFallbackService");
    }
}



