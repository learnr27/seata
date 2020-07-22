package com.cbb.seata.service.impl;

import com.cbb.seata.entity.Product;
import com.cbb.seata.mapper.ProductMapper;
import com.cbb.seata.service.ProductService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public void reduceStock(Long productId, Integer amount) throws Exception {
        log.info("[reduceStock] 当前 XID: {}", RootContext.getXID());
        // 检查库存
        checkStock(productId, amount);
        log.info("[reduceStock] 开始扣减 {} 库存", productId);
        // 扣减库存
        int updateCount = productMapper.reduceStock(productId, amount);
        // 扣除成功
        if (updateCount == 0) {
            log.warn("[reduceStock] 扣除 {} 库存失败", productId);
            throw new Exception("库存不足");
        }
        // 扣除失败
        log.info("[reduceStock] 扣除 {} 库存成功", productId);
    }

    private void checkStock(Long productId, Integer requiredAmount) throws Exception {
        log.info("[checkStock] 检查 {} 库存", productId);
        Product product = productMapper.selectById(productId);
        if (product.getStock() < requiredAmount) {
            log.warn("[checkStock] {} 库存不足，当前库存: {}", productId, product.getStock());
            throw new Exception("库存不足");
        }
    }
}
