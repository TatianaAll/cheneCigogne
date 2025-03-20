package com.cheneCigogne.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheneCigogne.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
