package cn.zyz.springcloud.service;

import cn.zyz.springcloud.entity.Payment;
import cn.zyz.springcloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentMapper mapper;

    public void create(Payment payment){
        mapper.create(payment);
    }
    public Payment getPaymentById(Long id){
        Payment paymentById = mapper.getPaymentById(id);
        return paymentById;
    }
}
