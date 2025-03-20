package com.cheneCigogne.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cheneCigogne.demo.dto.CategoryDto;
import com.cheneCigogne.demo.entity.Category;
import com.cheneCigogne.demo.entity.Dish;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.CategoryRepository;
import com.cheneCigogne.demo.service.serviceInterface.CategoryService;
import com.cheneCigogne.mapper.CategoryMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
  private CategoryRepository categoryRepository;

  @Override
  public CategoryDto createCategory(CategoryDto newCategoryDto) {
    Category newCategory = CategoryMapper.mapToCategory(newCategoryDto);
    Category savedCategory = categoryRepository.save(newCategory);
    return CategoryMapper.mapToCategoryDto(savedCategory);
  }

  @Override
  public CategoryDto getCategory(Long categoryId) {
    Category foundCategory = categoryRepository.findById(categoryId)
      .orElseThrow(()-> new NotFoundException("La catégorie de plat demandé n'existe pas"));
    return CategoryMapper.mapToCategoryDto(foundCategory);
  }

  @Override
  public List<Dish> getAllDishesInOneCategory(Long categoryId) {
   Category foundCategory = categoryRepository.findById(categoryId)
    .orElseThrow(()-> new NotFoundException("la categorie demandée n'existe pas"));
    List<Dish> dishesInCategory = foundCategory.getDishes();
    return dishesInCategory;
  }

  @Override
  public List<CategoryDto> getAllCategories() {
    List<Category> allCategories = categoryRepository.findAll();
    return allCategories.stream()
      .map((category) -> CategoryMapper.mapToCategoryDto(category))
      .collect(Collectors.toList());
  }

  @Override
  public CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory) {
    Category categoryToUpdate = categoryRepository.findById(categoryId)
      .orElseThrow(()-> new NotFoundException("Categorie introuvable"));

    categoryToUpdate.setName(updatedCategory.getName());
    Category updatedCategoryEntity = categoryRepository.save(categoryToUpdate);
    return CategoryMapper.mapToCategoryDto(updatedCategoryEntity);
  }

  @Override
  public void deleteCategory(Long categoryId) {
    Category categoryToDelete = categoryRepository.findById(categoryId)
      .orElseThrow(()-> new NotFoundException("categorie à supprimer introuvable"));
    categoryRepository.delete(categoryToDelete);
  }

}
