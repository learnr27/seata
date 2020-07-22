package com.cbb.seata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 支付金额
     */
    private Integer payAmount;

    /**
     * 购买数量
     */
    @TableField(exist = false)
    private Integer count;

    /**
     * 单价
     */
    @TableField(exist = false)
    private Integer money;

}
