package com.cbb.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbb.seata.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chengbb
 * @date 2020.7.14
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
