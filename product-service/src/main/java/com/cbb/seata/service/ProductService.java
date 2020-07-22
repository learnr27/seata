package com.cbb.seata.service;

/**
 * @author chengbb
 * @date 2020.7.14
 */
public interface ProductService {

    /**
     * 扣减库存
     *
     * @param productId
     * @param amount
     * @throws Exception
     */
    void reduceStock(Long productId, Integer amount) throws Exception;
}
