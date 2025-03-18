package com.cheneCigogne.mapper;


import com.cheneCigogne.demo.dto.CategoryDto;
import com.cheneCigogne.demo.entity.Category;

public class CategoryMapper {
  public static CategoryDto mapToCategoryDto(Category category) {
    return CategoryDto.builder()
      .id(category.getId())
      .name(category.getName())
      .build();
  }

  public static Category mapToCategory(CategoryDto categoryDto) {
    return Category.builder()
      .id(categoryDto.getId())
      .name(categoryDto.getName())
      .build();
  }

}
