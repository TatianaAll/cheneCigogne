package com.cheneCigogne.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheneCigogne.demo.entity.RestaurantOrder;
import com.cheneCigogne.demo.service.serviceInterface.OrderService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
  private OrderService orderService;

  @PostMapping("/create")
  public ResponseEntity<RestaurantOrder> createOrder(@RequestBody RestaurantOrder newOrder) {
      RestaurantOrder savedOrder = orderService.createOrder(newOrder);
      return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestaurantOrder> getOrder(@PathVariable("id") Long orderId) {
    RestaurantOrder foundOrder = orderService.getOrder(orderId);
    return ResponseEntity.ok(foundOrder);
  }
  
  
}
