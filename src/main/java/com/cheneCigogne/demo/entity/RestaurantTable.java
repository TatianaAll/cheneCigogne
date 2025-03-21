package com.cheneCigogne.demo.entity;

import org.apache.commons.lang3.BooleanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tables")
@Builder
public class RestaurantTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "table_number")
  private int table_number;

  @Column(name = "table_capacity")
  private int capacity;

  @Column(name = "available")
  private Boolean available;

  @OneToOne(mappedBy = "table")


  public boolean getAvailable() {
    return BooleanUtils.isTrue(this.available);
  }

}
