package cn.zyz.springcloud.controller;

import cn.zyz.springcloud.entity.CommonResult;
import cn.zyz.springcloud.entity.Payment;
import cn.zyz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService service;

    @Value("${server.port}")
    String port;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectById(@PathVariable("id") Long id){
        Payment paymentById = paymentById = service.getPaymentById(id);
        if (paymentById==null){
            log.error("==========查询失败==========");
            CommonResult result = new CommonResult<Payment>(500,"查询失败,没有对应记录");
            return result;
        }else {
            log.info("==========查询成功==========");
            CommonResult result = new CommonResult(200, "查询成功,serverPort"+port, paymentById);
            return result;
        }
    }

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        try {
            service.create(payment);
        } catch (Exception e) {
            log.error("==========插入失败==========");
            CommonResult result = new CommonResult<Payment>(500,"fail");
            return result;
        }
        log.info("==========插入成功==========");
        CommonResult result = new CommonResult(200,"success,serverPort:"+port,payment);
        return result;
    }
}
