package com.cheneCigogne.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantTableDto {
  private Long id;
  private int table_number;
  private int table_capacity;
}
