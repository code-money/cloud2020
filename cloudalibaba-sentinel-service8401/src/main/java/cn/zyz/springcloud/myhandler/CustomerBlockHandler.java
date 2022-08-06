package cn.zyz.springcloud.myhandler;

import cn.zyz.springcloud.entity.CommonResult;
import cn.zyz.springcloud.entity.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @program: cloud2020
 * @author: zyz
 * @create: 2022-08-04 10:22
 **/

//限流兜底方法类
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444,"按客户自定义,global Exception----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义,global Exception----2");
    }
}



