package com.cheneCigogne.demo.service.serviceInterface;

import java.util.List;

import com.cheneCigogne.demo.entity.Dish;

public interface DishService {
  Dish createDish(Dish newDish);

  Dish getDishById(Long dishId);

  List<Dish> getAllDishes();

  Dish updateDish(Long dishId, Dish updatedDish);

  void deleteDish(Long dishId);
}
