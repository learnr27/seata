package com.cbb.seata.controller;

import com.cbb.seata.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/reduceStock")
    public void reduceStock(@RequestParam("productId") Long productId, @RequestParam("amount") Integer amount)
            throws Exception {
        productService.reduceStock(productId, amount);
    }
}
