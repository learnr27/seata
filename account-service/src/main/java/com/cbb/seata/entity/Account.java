package com.cbb.seata.entity;

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
@TableName("account")
public class Account implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 扣减金额
     */
    private Integer balance;
}
