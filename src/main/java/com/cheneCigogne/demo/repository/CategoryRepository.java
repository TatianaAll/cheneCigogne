package com.cheneCigogne.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheneCigogne.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
