package com.cbb.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbb.seata.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @Update("UPDATE product SET stock = stock - #{count} WHERE id = #{productId} AND stock >= #{count}")
    int reduceStock(@Param("productId") Long productId, @Param("count") Integer count);
}
