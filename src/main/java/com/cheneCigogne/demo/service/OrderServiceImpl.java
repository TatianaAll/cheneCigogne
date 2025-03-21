package com.cheneCigogne.demo.service;

import org.springframework.stereotype.Service;

import com.cheneCigogne.demo.entity.RestaurantOrder;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.OrderRepository;
import com.cheneCigogne.demo.service.serviceInterface.OrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
  private OrderRepository orderRepository;

  @Override
  public RestaurantOrder createOrder(RestaurantOrder newOrder) {
    RestaurantOrder savedOrder = orderRepository.save(newOrder);
    return savedOrder;
  }

  @Override
  public RestaurantOrder getOrder(Long orderId) {
    RestaurantOrder foundOrder = orderRepository.findById(orderId)
      .orElseThrow(()->new NotFoundException("La commande n'a pas été trouvée"));
    return foundOrder;
  }

  @Override
  public RestaurantOrder updateOrder(RestaurantOrder updatedOrder, Long orderId) {
    RestaurantOrder foundOrder = orderRepository.findById(orderId)
      .orElseThrow(()->new NotFoundException("La commande n'a pas été trouvée"));
    foundOrder.setStatus(updatedOrder.getStatus());
    foundOrder.setTable(updatedOrder.getTable());
    foundOrder.setTotalPrice(updatedOrder.getTotalPrice());
    
    return orderRepository.save(foundOrder);
  }

  @Override
  public void deleteOrder(Long orderId) {
    RestaurantOrder foundOrder = orderRepository.findById(orderId)
    .orElseThrow(()->new NotFoundException("La commande n'a pas été trouvée"));
    orderRepository.delete(foundOrder);
  }

}
