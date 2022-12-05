# Saga Pattern Microservices

Simple order flow to demo some concepts:

- Microservices using `Spring Boot`, `Spring Cloud`, `Spring Cloud Stream`
- Database per service using `Postgresql`
- Saga Pattern (Saga Orchestration): Distributed transaction span multiple services.
- Outbox Pattern: Avoid dual-writes, no 2PC required using `Kafka`,`Kafka Connect`, `Debezium`, `Outbox Event Router`

## Prerequisites

- `Java 17`
- `Docker`
- `Docker-compose`

## Get Started

### Setup environment

```shell
docker-compose up -d
```

### Build projects

```shell
./mvnw clean package -DskipTests=true
```

### Start Services

Run service `order-service`

```shell
./mvnw -f pom.xml spring-boot:run
```

| Service's name | Endpoint       |
| --- |----------------|
| Order service | localhost:8080 |

### Start outbox connectors

Create outbox connectors

```shell
sh register-connectors.sh
```

### Clean Up

Delete all connectors

```shell
sh delete-connectors.sh
```
