package com.example.orders.domain.port;

import java.util.Optional;
import java.util.UUID;
import com.example.orders.domain.entity.Order;

public interface OrderRepositoryPort {

  Optional<Order> findOrderById(UUID orderId);

  void saveOrder(Order order);

  void exportOutBoxEvent(Order order);
}
