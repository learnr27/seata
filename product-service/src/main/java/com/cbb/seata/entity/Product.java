package com.cbb.seata.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("product")
public class Product {

    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 库存量
     */
    private Integer stock;

}
