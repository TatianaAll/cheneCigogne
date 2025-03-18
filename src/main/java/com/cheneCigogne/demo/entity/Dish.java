package com.cheneCigogne.demo.entity;

import org.apache.commons.lang3.BooleanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "dishes")
public class Dish {
  public Dish(Long id, String name, String description, float price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.available = false;
  };

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  private String description;

  @Column(name = "price")
  private float price;

  private String image;

  @Column(name = "available")
  private Boolean available;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = true)
  private Category category;

  public boolean getAvailable() {
    return BooleanUtils.isTrue(this.available);
  }

}
