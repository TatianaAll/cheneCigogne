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
}
