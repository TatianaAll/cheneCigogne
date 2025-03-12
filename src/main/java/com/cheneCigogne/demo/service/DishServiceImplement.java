package com.cheneCigogne.demo.service;

import org.springframework.stereotype.Service;

import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.entity.Dish;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.DishRepository;
import com.cheneCigogne.mapper.DishMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DishServiceImplement implements DishService {
    private DishRepository dishRepository;

    @Override
    public DishDto createDishFromDto(DishDto dishDto) {
        Dish dish = DishMapper.mapToDish(dishDto);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.mapToDishDto(savedDish);
    }

    @Override
    public DishDto getDishDtoById(Long DishId) {
        Dish foundDish = dishRepository.findById(DishId)
            .orElseThrow(() -> 
                new NotFoundException("Le plat recherché n'existe pas"));
        return DishMapper.mapToDishDto(foundDish);
    };
}
