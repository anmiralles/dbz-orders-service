package com.example.orders.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.example.orders.domain.entity.Order;
import com.example.orders.domain.port.OrderRepositoryPort;
import com.example.orders.infrastructure.message.outbox.OutBox;
import com.example.orders.infrastructure.message.outbox.OutBoxRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import static com.example.orders.infrastructure.message.EventHandlerAdapter.ORDER;
import static com.example.orders.infrastructure.message.EventHandlerAdapter.ORDER_CREATED;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {

  private final ObjectMapper mapper;

  private final OrderJpaRepository orderJpaRepository;

  private final OutBoxRepository outBoxRepository;

  @Override
  public Optional<Order> findOrderById(UUID orderId) {
    return orderJpaRepository
        .findById(orderId)
        .map(orderEntity -> mapper.convertValue(orderEntity, Order.class));
  }

  @Override
  public void saveOrder(Order order) {
    var entity = mapper.convertValue(order, OrderEntity.class);
    orderJpaRepository.save(entity);
  }

  @Override
  public void exportOutBoxEvent(Order order) {
    var outbox =
        OutBox.builder()
            .aggregateId(order.getId())
            .aggregateType(ORDER)
            .type(ORDER_CREATED)
            .payload(mapper.convertValue(order, JsonNode.class))
            .build();
    outBoxRepository.save(outbox);
  }
}
