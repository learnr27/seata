package com.cbb.seata.service;

import com.cbb.seata.entity.CommonResult;
import com.cbb.seata.entity.Order;

/**
 * @author chengbb
 * @date 2020.7.14
 */
public interface OrderService {

    /**
     * 创建
     *
     * @param order
     * @return
     */
    CommonResult createOrder(Order order);
}
