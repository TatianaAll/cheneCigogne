package com.cheneCigogne.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cheneCigogne.demo.entity.Dish;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.DishRepository;
import com.cheneCigogne.demo.service.serviceInterface.DishService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DishServiceImplement implements DishService {
  private DishRepository dishRepository;

  @Override
  public Dish createDish(Dish newDish) {
    return dishRepository.save(newDish);
  }

  @Override
  public Dish getDishById(Long dishId) {
    return dishRepository.findById(dishId)
        .orElseThrow(() -> new NotFoundException("Le plat recherché n'existe pas"));
  }

  @Override
  public List<Dish> getAllDishes() {
    return dishRepository.findAll();
  }

  @Override
  public Dish updateDish(Long dishId, Dish updatedDish) {
    Dish dishToUpdate = dishRepository.findById(dishId) 
      .orElseThrow(() -> new NotFoundException("Impossible de modifier un plat inexistant"));
    
      dishToUpdate.setName(updatedDish.getName());
      dishToUpdate.setDescription(updatedDish.getDescription());
      dishToUpdate.setPrice(updatedDish.getPrice());

      return dishRepository.save(dishToUpdate);
  }

  @Override
  public void deleteDish(Long dishId) {
    Dish dishToDelete = dishRepository.findById(dishId)
      .orElseThrow(() -> new NotFoundException("le plat à supprimé n'existe pas"));

      dishRepository.delete(dishToDelete);
  };

  
}
