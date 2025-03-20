package com.cheneCigogne.demo.service;

import com.cheneCigogne.demo.entity.Order;
import com.cheneCigogne.demo.exception.NotFoundException;
import com.cheneCigogne.demo.repository.OrderRepository;
import com.cheneCigogne.demo.service.serviceInterface.OrderService;

public class OrderServiceImpl implements OrderService {
  private OrderRepository orderRepository;

  @Override
  public Order createOrder(Order newOrder) {
    Order savedOrder = orderRepository.save(newOrder);
    return savedOrder;
  }

  @Override
  public Order getOrder(Long orderId) {
    Order foundOrder = orderRepository.findById(orderId)
      .orElseThrow(()->new NotFoundException("La commande n'a pas été trouvée"));
    return foundOrder;
  }

  @Override
  public Order updateOrder(Order updatedOrder, Long orderId) {
    Order foundOrder = orderRepository.findById(orderId)
      .orElseThrow(()->new NotFoundException("La commande n'a pas été trouvée"));
    foundOrder.setStatus(updatedOrder.getStatus());
    foundOrder.setTable(updatedOrder.getTable());
    foundOrder.setTotalPrice(updatedOrder.getTotalPrice());
    
    return orderRepository.save(foundOrder);
  }

  @Override
  public void deleteOrder(Long orderId) {
    Order foundOrder = orderRepository.findById(orderId)
    .orElseThrow(()->new NotFoundException("La commande n'a pas été trouvée"));
    orderRepository.delete(foundOrder);
  }

}
