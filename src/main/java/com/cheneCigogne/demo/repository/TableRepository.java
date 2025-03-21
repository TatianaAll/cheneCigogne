package com.cheneCigogne.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheneCigogne.demo.entity.RestaurantTable;

public interface TableRepository extends JpaRepository<RestaurantTable, Long> {

}
