package com.cheneCigogne.demo.entity;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
public class RestaurantOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "total_price")
  private float totalPrice;

  @Column(name = "created_at", nullable = false)
  @CreatedDate
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private Order_status status;

  @OneToOne
  @JoinColumn(name = "table_id", unique = true, nullable = false)
  private RestaurantTable table;
}