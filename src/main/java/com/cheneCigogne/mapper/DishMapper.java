package com.cheneCigogne.mapper;

import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.entity.Dish;

public class DishMapper {

    public static DishDto mapToDishDto(Dish dish) {
        return new DishDto(
            dish.getId(),
            dish.getName(),
            dish.getDescription(),
            dish.getPrice()
        );
    }

    public static Dish mapToDish(DishDto dishDto) {
        return new Dish(
            dishDto.getId(),
            dishDto.getName(),
            dishDto.getDescription(),
            dishDto.getPrice(), 
            "null",
            false
        );
    }

}
