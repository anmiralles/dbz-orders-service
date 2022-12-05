package com.example.orders.domain;

import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record OrderRequest(@NotNull UUID customerId, @NotNull UUID productId, @Min(1)@NotNull Integer quantity,
                           BigDecimal price) {
}
