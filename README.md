# Order Service – REST API + Kafka Publisher (Option 2)

A minimal Spring Boot service that exposes a `POST /orders` endpoint and publishes an `order.created` event to Kafka.

## Architecture

- **Order Service** (this app) publishes `order.created` to Kafka
- Other services (Payment, Inventory, Notification) can subscribe to the topic

## Run Locally with Docker Compose

Requirements:
- Docker & Docker Compose

```bash
# from project root
docker compose up --build
```

This starts:
- Zookeeper (2181)
- Kafka broker (9092 on host)
- Order Service (8080 on host)

## Send a Test Request

```bash
curl -X POST http://localhost:8080/orders   -H "Content-Type: application/json"   -d '{
    "orderId": "ORD-1001",
    "customerEmail": "tito@test.com",
    "productId": "SKU-123",
    "quantity": 2
  }'
```

Expected Response: HTTP 202 Accepted with JSON body acknowledging publish.

## Configuration

- Kafka bootstrap servers: `spring.kafka.bootstrap-servers` (defaults to `localhost:9092`)
- Topic name: `app.kafka.topic.orderCreated` (defaults to `order.created`)

You can override via env var for the bootstrap servers:
```
KAFKA_BOOTSTRAP_SERVERS=kafka:9092
```

## Project Structure

```
src/main/java/com/titobiloluwa/orderservice
├── OrderServiceApplication.java
├── config
│   └── KafkaTopicsConfig.java
├── controller
│   └── OrderController.java
├── model
│   ├── OrderCreatedEvent.java
│   └── OrderRequest.java
└── service
    └── OrderEventPublisher.java

src/main/resources
└── application.yml
```

## Notes

- No database is used (kept intentionally simple for the interview task).
- The topic is created on startup (via `NewTopic` bean); broker must allow topic creation.
- Uses JSON value serialization for event payloads.
```

# ebsafr-task
