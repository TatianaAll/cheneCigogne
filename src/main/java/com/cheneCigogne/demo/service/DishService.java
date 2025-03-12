package com.cheneCigogne.demo.service;

import java.util.List;

import com.cheneCigogne.demo.dto.DishDto;

public interface DishService {
  DishDto createDishFromDto(DishDto dishDto);

  DishDto getDishDtoById(Long DishId);

  List<DishDto> getAllDishesDto();
}
