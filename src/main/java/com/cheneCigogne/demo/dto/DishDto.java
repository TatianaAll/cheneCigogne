package com.cheneCigogne.demo.dto;

import com.cheneCigogne.demo.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishDto {
  private Long id;
  private String name;
  private String description;
  private Float price;
  private Category category;
}
