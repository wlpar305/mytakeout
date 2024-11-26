package com.sky.mapper;
import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {
    Integer countByCategoryId(@Param("categoryId") Long categoryId);

    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    Dish getById(Long id);

    void deleteById(Long id);

    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    List<DishVO> list(Dish dish);

    List<Dish> getBySetmealId(Long id);

    Integer countByMap(Map map);
}
