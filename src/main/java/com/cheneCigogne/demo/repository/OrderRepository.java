package com.cheneCigogne.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheneCigogne.demo.entity.RestaurantOrder;

public interface OrderRepository extends JpaRepository<RestaurantOrder, Long>{

}
