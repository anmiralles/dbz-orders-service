package com.example.orders.api;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.orders.domain.OrderRequest;
import com.example.orders.domain.port.OrderUseCasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderUseCasePort orderUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void placeOrder(@RequestBody @Valid OrderRequest orderRequest) {
    log.info("Received new order request {}", orderRequest);
    orderUseCase.placeOrder(orderRequest);
  }
}
