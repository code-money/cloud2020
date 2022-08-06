package cn.zyz.springcloud.service;

import cn.zyz.springcloud.domain.Order;


public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
