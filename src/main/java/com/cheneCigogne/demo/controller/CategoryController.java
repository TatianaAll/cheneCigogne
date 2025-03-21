package com.cheneCigogne.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheneCigogne.demo.dto.CategoryDto;
import com.cheneCigogne.demo.entity.Dish;
import com.cheneCigogne.demo.service.serviceInterface.CategoryService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

  private CategoryService categoryService;

  @PostMapping("create")
  public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CategoryDto newCategory) {
    categoryService.createCategory(newCategory);
    return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId) {
      CategoryDto foundCategory = categoryService.getCategory(categoryId);
      return ResponseEntity.ok(foundCategory);
  }
  
  @GetMapping("{id}/dishes")
  public ResponseEntity<List<Dish>> getAllDishesInOneCategory(@PathVariable ("id") Long categoryId) {
    List<Dish> dishesInFoundCategory = categoryService.getAllDishesInOneCategory(categoryId);
    return ResponseEntity.ok(dishesInFoundCategory);
  }

  @GetMapping("all")
  public ResponseEntity<List<CategoryDto>> getAllCategories() {
    var allCategories = categoryService.getAllCategories();
    return ResponseEntity.ok(allCategories);
  }

  @PutMapping("{id}/update")
  public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId, CategoryDto category) {
  CategoryDto updatedCategory = categoryService.updateCategory(categoryId, category);
    return ResponseEntity.ok(updatedCategory);  
  }
  
  @DeleteMapping("{id}/delete")
  public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
    categoryService.deleteCategory(categoryId);
    return ResponseEntity.ok("Catégorie supprimée");
  }

}
