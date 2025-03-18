package com.cheneCigogne.mapper;

import com.cheneCigogne.demo.dto.CategoryDto;
import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.entity.Dish;

public class DishMapper {

  public static DishDto mapToDishDto(Dish dish) {
    return DishDto.builder()
        .id(dish.getId())
        .name(dish.getName())
        .description(dish.getDescription())
        .price(dish.getPrice())
        .categoryDto(
          CategoryDto.builder()
          .id(dish.getCategory().getId())
          .name(dish.getCategory().getName())
          .build()
        )
        .build();
  }

  public static Dish mapToDish(DishDto dishDto) {
    return new Dish(
        dishDto.getId(),
        dishDto.getName(),
        dishDto.getDescription(),
        dishDto.getPrice());
  }

}
