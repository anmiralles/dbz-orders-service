package com.example.orders.infrastructure.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import com.example.orders.domain.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class OrderEntity {

  @Id
  private UUID id;

  @Column(nullable = false)
  private UUID customerId;

  @Column(nullable = false)
  private UUID productId;

  private BigDecimal price;

  private int quantity;

  private Timestamp createdAt;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
