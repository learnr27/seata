package com.cbb.seata.service.impl;

import com.cbb.seata.entity.CommonResult;
import com.cbb.seata.entity.Order;
import com.cbb.seata.feign.AccountService;
import com.cbb.seata.feign.ProductService;
import com.cbb.seata.mapper.OrderMapper;
import com.cbb.seata.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private ProductService productService;

    @Override
    @GlobalTransactional
    public CommonResult createOrder(Order order) {

        log.info("----->开始新建订单 当前 XID: {}", RootContext.getXID());
        int money = order.getMoney() * order.getCount();
        order.setPayAmount(money);
        orderMapper.insert(order);

        log.info("----->订单微服务开始调用库存，做扣减Count");
        productService.reduceStock(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");


        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.reduceBalance(order.getUserId(), money);
        log.info("----->订单微服务开始调用账户，做扣减end");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~ 订单号：{}", order.getId());

        return new CommonResult(200, "订单创建成功", order.getId());
    }
}
