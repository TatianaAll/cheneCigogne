package com.cheneCigogne.demo.service.serviceInterface;

import com.cheneCigogne.demo.entity.RestaurantOrder;

public interface OrderService {
  RestaurantOrder createOrder(RestaurantOrder newOrder);

  RestaurantOrder getOrder(Long orderId);

  RestaurantOrder updateOrder (RestaurantOrder updatedOrder, Long orderId);

  void deleteOrder(Long orderId);
  
}
