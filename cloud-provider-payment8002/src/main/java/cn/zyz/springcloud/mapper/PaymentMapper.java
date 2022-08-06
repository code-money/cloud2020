package cn.zyz.springcloud.mapper;


import cn.zyz.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
     void create(Payment payment);
     Payment getPaymentById(Long id);
}
