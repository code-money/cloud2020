package cn.zyz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2020
 * @author: zyz
 * @create: 2022-08-03 15:42
 **/

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

    //降级测试
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age =10/0;
        return "------testE 测试异常数";
    }


    //热点key限流测试
    @GetMapping("/testHotkey")
    //blockHandler指定了流控方法，如果方法内有运行时异常的话，不会执行指定方法，而是直接抛异常
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "-----------testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception){
        return "------------deal_testHotkey,┭┮﹏┭┮";
    }
}


