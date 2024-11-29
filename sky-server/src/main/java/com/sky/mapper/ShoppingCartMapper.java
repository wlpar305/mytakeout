package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    List<ShoppingCart> list(ShoppingCart shoppingCart);
    void updateNumberById(ShoppingCart shoppingCart);
    void insert(ShoppingCart shoppingCart);
    void deleteByUserId(Long currentId);
    void deleteById(Long id);
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
