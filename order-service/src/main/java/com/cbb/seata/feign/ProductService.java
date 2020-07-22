package com.cbb.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@FeignClient(name = "product-service")
public interface ProductService {

    /**
     * 商品减少库存
     *
     * @param productId
     * @param amount
     */
    @PostMapping("/product/reduceStock")
    void reduceStock(@RequestParam("productId") Long productId, @RequestParam("amount") Integer amount);
}
