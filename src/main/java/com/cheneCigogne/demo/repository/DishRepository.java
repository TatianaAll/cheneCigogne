package com.cheneCigogne.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheneCigogne.demo.entity.Dish;

//extends JpaRepository so no need to annotate @Repository cause the parent did it
public interface DishRepository extends JpaRepository<Dish, Long>{

}
