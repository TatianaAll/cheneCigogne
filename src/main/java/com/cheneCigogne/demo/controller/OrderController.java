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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




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

  @PutMapping("{id}/update")
  public ResponseEntity<RestaurantOrder> updateOrder(@PathVariable("id") Long orderId, RestaurantOrder orderUpdated) {
    RestaurantOrder orderToUpdate = orderService.updateOrder(orderUpdated, orderId);
    return ResponseEntity.ok(orderToUpdate);
  }

  @DeleteMapping("{id}/delete")
  public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
    orderService.deleteOrder(orderId);
    return ResponseEntity.ok("Commande supprimée avec succès");
  }
  
  
}
