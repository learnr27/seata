package com.cbb.seata.controller;

/**
 * @author chengbb
 * @date 2020.7.21
 */

import com.cbb.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/reduceBalance")
    public void reduceBalance(@RequestParam("userId") Long userId, @RequestParam("price") Integer price) throws Exception {
        log.info("[reduceBalance] 收到减少余额请求, 用户:{}, 金额:{}", userId, price);
        accountService.reduceBalance(userId, price);
    }
}
