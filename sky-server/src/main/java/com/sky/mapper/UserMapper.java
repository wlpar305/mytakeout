package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.User;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import java.util.Map;

@Mapper
public interface UserMapper {
    User getById(String id);
    User getByOpenId(@Param("openid") String openId);

    @AutoFill(OperationType.INSERT)
    void insert(User user);

    Integer countByMap(Map map);
}
