package com.cheneCigogne.demo.service.serviceInterface;

import java.util.List;

import com.cheneCigogne.demo.dto.CategoryDto;
import com.cheneCigogne.demo.entity.Dish;

public interface CategoryService {
  CategoryDto createCategory(CategoryDto newCategory);

  CategoryDto getCategory(Long categoryId);

  List<Dish> getAllDishesInOneCategory(Long categoryId);

  List<CategoryDto> getAllCategories();

  CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory);

  void deleteCategory(Long categoryId);


}
