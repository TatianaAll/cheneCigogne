package com.cheneCigogne.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.service.serviceInterface.DishService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/dishes")
public class DishController {

  private DishService dishService;

  // Build REST API for dish addition
  @PostMapping
  public ResponseEntity<DishDto> createDishDto(@RequestBody DishDto dishDto) {
    DishDto savedDish = dishService.createDishFromDto(dishDto);
    return new ResponseEntity<>(savedDish, HttpStatus.CREATED);
  }

  //Dish research by id
  @GetMapping("{id}")
  public ResponseEntity<DishDto> getDishDtoById(@PathVariable("id") Long dishId) {
    DishDto dishFound = dishService.getDishDtoById(dishId);
      return ResponseEntity.ok(dishFound);
  }

  //dish all research
  @GetMapping
  public ResponseEntity<List<DishDto>> getAllDishesDto() {
    var allDishesDto = dishService.getAllDishesDto();
    return ResponseEntity.ok(allDishesDto);
  }
  
  //update dish
  @PutMapping("{id}")
  public ResponseEntity<DishDto> updateDish(@PathVariable("id") Long dishId, @RequestBody DishDto updatedDishDto) {
    DishDto dishToUpdate = dishService.updateDishFromDto(dishId, updatedDishDto);
    return ResponseEntity.ok(dishToUpdate);
  }

  //delete dish
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteDish(@PathVariable("id") Long dishId) {
    dishService.deleteDish(dishId);
    return ResponseEntity.ok("Plat supprimé avec succès"); 
  }
}
