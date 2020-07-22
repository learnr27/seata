package com.cbb.seata.service;

/**
 * @author chengbb
 * @date 2020.7.14
 */
public interface AccountService {

    /**
     * 扣除余额
     *
     * @param userId
     * @param price
     * @throws Exception
     */
    void reduceBalance(Long userId, Integer price) throws Exception;
}
