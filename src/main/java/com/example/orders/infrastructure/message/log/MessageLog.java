package com.example.orders.infrastructure.message.log;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MessageLog {

  @Id private UUID id;

  @Column(nullable = false)
  private Timestamp receivedAt;
}
