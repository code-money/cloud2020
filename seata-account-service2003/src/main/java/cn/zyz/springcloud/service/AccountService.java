package cn.zyz.springcloud.service;


import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(Long userId,BigDecimal money);
}
