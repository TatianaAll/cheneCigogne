package com.cheneCigogne.demo.service;

import java.util.List;

import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.entity.Category;

public interface CategoryService {
  Category createCategory(Category newCategory);

  Category getCategory(Long categoryId);

  List<DishDto> getAllDishesInOneCategory(Long categoryId);

  Category updateCategory(Long categoryId, Category updatedCategory);

  void deleteCategory(Long categoryId);


}
