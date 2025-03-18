package com.cheneCigogne.mapper;

import com.cheneCigogne.demo.dto.RestaurantTableDto;
import com.cheneCigogne.demo.entity.RestaurantTable;

public class TableMapper {
  public static RestaurantTableDto mapToTableDto(RestaurantTable table) {
    return RestaurantTableDto.builder()
      .id(table.getId())
      .table_number(table.getTable_number())
      .table_capacity(table.getCapacity())
      .build();
  }

  public static RestaurantTable mapToTable(RestaurantTableDto tableDto) {
    return RestaurantTable.builder()
      .id(tableDto.getId())
      .table_number(tableDto.getTable_number())
      .capacity(tableDto.getTable_capacity())
      .build();
  }
}
