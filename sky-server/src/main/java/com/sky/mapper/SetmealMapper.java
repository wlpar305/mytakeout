package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SetmealMapper {
    Integer countByCategoryId(@Param("categoryId") Long categoryId);

    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);

    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    Setmeal getById(Long id);

    void deleteById(Long id);

    @AutoFill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    List<Setmeal> list(Setmeal setmeal);

    List<DishItemVO> getDishItemBySetmealId(Long id);

    Integer countByMap(Map map);
}
