package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SetmealDishMapper {
    List<Long> getSetmealIdsByDishIds(List<Long> ids);
    void insertBatch(List<SetmealDish> setmealDishes);
    void deleteBySetmaleId(Long id);
    List<SetmealDish> getBySetmealId(Long id);
}
