package com.cheneCigogne.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.service.DishService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@RestController
@RequestMapping("/api/dishes")
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
  
}
