package com.cheneCigogne.demo.service.serviceInterface;

import com.cheneCigogne.demo.entity.Order;

public interface OrderService {
  Order createOrder(Order newOrder);

  Order getOrder(Long orderId);

  Order updateOrder (Order updatedOrder, Long orderId);

  void deleteOrder(Long orderId);
  
}
