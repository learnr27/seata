package com.cbb.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbb.seata.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 扣减余额
     *
     * @param price
     * @return
     */
    @Update("UPDATE account SET balance = balance - #{price} WHERE id = 1 AND balance >= ${price}")
    int reduceBalance(@Param("price") Integer price);
}
