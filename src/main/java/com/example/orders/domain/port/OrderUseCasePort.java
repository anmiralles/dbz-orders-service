package com.example.orders.domain.port;

import java.util.UUID;
import com.example.orders.domain.OrderRequest;

public interface OrderUseCasePort {

  void placeOrder(OrderRequest orderRequest);

  void updateOrderStatus(UUID orderId, boolean success);
}
