package com.cbb.seata.controller;

import com.cbb.seata.entity.CommonResult;
import com.cbb.seata.entity.Order;
import com.cbb.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/create")
    public CommonResult createOrder(@RequestBody Order order) throws Exception {
        return orderService.createOrder(order);
    }
}
