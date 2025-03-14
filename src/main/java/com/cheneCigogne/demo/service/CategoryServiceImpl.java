package com.cheneCigogne.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cheneCigogne.demo.dto.DishDto;
import com.cheneCigogne.demo.entity.Category;
import com.cheneCigogne.demo.entity.Dish;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.CategoryRepository;
import com.cheneCigogne.mapper.DishMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
  private CategoryRepository categoryRepository;

  @Override
  public Category createCategory(Category newCategory) {
    return categoryRepository.save(newCategory);
  }

  @Override
  public Category getCategory(Long categoryId) {
    Category foundCategory = categoryRepository.findById(categoryId)
      .orElseThrow(()-> new NotFoundException("La catégorie de plat demandé n'existe pas"));
    return foundCategory;
  }

  @Override
  public List<DishDto> getAllDishesInOneCategory(Long categoryId) {
   Category foundCategory = categoryRepository.findById(categoryId)
    .orElseThrow(()-> new NotFoundException("la categorie demandée n'existe pas"));
    List<Dish> dishesInCategory = foundCategory.getDishes();
    List<DishDto> foundDishes = dishesInCategory.stream()
      .map((dish) -> DishMapper.mapToDishDto(dish))
      .collect(Collectors.toList());
    return foundDishes;
  }

  @Override
  public Category updateCategory(Long categoryId, Category updatedCategory) {
    Category categoryToUpdate = categoryRepository.findById(categoryId)
      .orElseThrow(()-> new NotFoundException("Categorie introuvable"));

    categoryToUpdate.setName(updatedCategory.getName());;
    return categoryRepository.save(categoryToUpdate);
  }

  @Override
  public void deleteCategory(Long categoryId) {
    Category categoryToDelete = categoryRepository.findById(categoryId)
      .orElseThrow(()-> new NotFoundException("categorie à supprimer introuvable"));
    categoryRepository.delete(categoryToDelete);
  }

}
