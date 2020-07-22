package com.cbb.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@FeignClient(name = "account-service")
public interface AccountService {

    /**
     * 账户减少余额
     *
     * @param userId
     * @param price
     */
    @PostMapping("/account/reduceBalance")
    void reduceBalance(@RequestParam("userId") Long userId, @RequestParam("price") Integer price);
}
