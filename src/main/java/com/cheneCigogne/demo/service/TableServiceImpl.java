package com.cheneCigogne.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cheneCigogne.demo.dto.RestaurantTableDto;
import com.cheneCigogne.demo.entity.RestaurantTable;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.RestaurantTableRepository;
import com.cheneCigogne.demo.service.serviceInterface.RestaurantTableService;
import com.cheneCigogne.mapper.TableMapper;

public class TableServiceImpl implements RestaurantTableService {

  private RestaurantTableRepository tableRepository;

  @Override
  public RestaurantTableDto createTable(RestaurantTableDto tableDto) {
    RestaurantTable newTable = TableMapper.mapToTable(tableDto);
    RestaurantTable savedTable = tableRepository.save(newTable);
    return TableMapper.mapToTableDto(savedTable);
  }

  @Override
  public RestaurantTableDto getTable(Long tableId) {
    RestaurantTable foundTable = tableRepository.findById(tableId)
      .orElseThrow(()-> new NotFoundException("Table inexistante"));
    return TableMapper.mapToTableDto(foundTable);
  }

  @Override
  public List<RestaurantTableDto> getAllTables() {
    List<RestaurantTable> allTables = tableRepository.findAll();
    return allTables.stream()
      .map((table)->TableMapper.mapToTableDto(table))
      .collect(Collectors.toList());
  }

  @Override
  public RestaurantTableDto updateTable(Long tableId, RestaurantTableDto updateTableDto) {
    RestaurantTable foundTable = tableRepository.findById(tableId)
    .orElseThrow(()-> new NotFoundException("Table inexistante"));

    //attribute new values
    foundTable.setTable_number(updateTableDto.getTable_number());
    foundTable.setCapacity(updateTableDto.getTable_capacity());
    RestaurantTable updatedTable = tableRepository.save(foundTable);
    
    return TableMapper.mapToTableDto(updatedTable);
  }

  @Override
  public void deleteTable(Long tableId) {
    RestaurantTable tableToDelete = tableRepository.findById(tableId)
      .orElseThrow(()-> new NotFoundException("Table à supprimer inexistante"));
    tableRepository.delete(tableToDelete);
  }

}
