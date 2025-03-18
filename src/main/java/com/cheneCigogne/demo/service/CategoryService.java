package com.cheneCigogne.demo.service;

import java.util.List;

import com.cheneCigogne.demo.dto.CategoryDto;
import com.cheneCigogne.demo.dto.DishDto;

public interface CategoryService {
  CategoryDto createCategory(CategoryDto newCategory);

  CategoryDto getCategory(Long categoryId);

  List<DishDto> getAllDishesInOneCategory(Long categoryId);

  List<CategoryDto> getAllCategories();

  CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory);

  void deleteCategory(Long categoryId);


}
