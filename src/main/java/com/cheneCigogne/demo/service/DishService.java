package com.cheneCigogne.demo.service;

import com.cheneCigogne.demo.dto.DishDto;

public interface DishService {
    DishDto createDishFromDto(DishDto dishDto);

    DishDto getDishDtoById(Long DishId);
}
