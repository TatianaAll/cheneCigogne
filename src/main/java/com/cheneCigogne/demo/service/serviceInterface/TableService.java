package com.cheneCigogne.demo.service.serviceInterface;

import java.util.List;

import com.cheneCigogne.demo.dto.RestaurantTableDto;

public interface TableService {
  RestaurantTableDto createTable(RestaurantTableDto tableDto);

  RestaurantTableDto getTable(Long tableId);

  List<RestaurantTableDto> getAllTables();

  RestaurantTableDto updateTable(Long tableId, RestaurantTableDto updateTableDto);

  void deleteTable(Long tableId);
}
