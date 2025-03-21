package com.cheneCigogne.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheneCigogne.demo.dto.RestaurantTableDto;
import com.cheneCigogne.demo.service.serviceInterface.TableService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/table")
public class RestaurantTableController {

  private TableService tableService;

  @PostMapping("/create")
  public ResponseEntity<RestaurantTableDto> createNewTable(@RequestBody RestaurantTableDto newTable) {
      tableService.createTable(newTable);
      return new ResponseEntity<>(newTable, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestaurantTableDto> getTableById(@PathVariable("id") Long tableId) {
    RestaurantTableDto foundTable = tableService.getTable(tableId);
    return ResponseEntity.ok(foundTable);
  }
  
  @GetMapping("/all")
  public ResponseEntity<List<RestaurantTableDto>> getAllTables() {
    List<RestaurantTableDto> allTables = tableService.getAllTables();
    return ResponseEntity.ok(allTables);
  }

  @PutMapping("{id}/update")
  public ResponseEntity<RestaurantTableDto> updateTable(@PathVariable("id") Long tableId, RestaurantTableDto tableUpdated) {
    RestaurantTableDto tableToUpdate = tableService.updateTable(tableId, tableUpdated);
    return ResponseEntity.ok(tableToUpdate);
  }

  @DeleteMapping("/{id}/delete")
  public ResponseEntity<String> deleteTable(@PathVariable("id") Long tableId) {
    tableService.deleteTable(tableId);
    return ResponseEntity.ok("La table a été supprimée avec succès !");
  }
}
