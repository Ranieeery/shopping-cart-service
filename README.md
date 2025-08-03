# Shopping Cart Service

A modern shopping cart microservice built with Spring Boot, featuring MongoDB for data persistence, Redis for caching,
and integration with external product APIs.

## Features

- **Shopping Cart Management**: Create, update, and manage shopping carts
- **Product Integration**: Fetch products from external APIs (Platzi Fake Store API)
- **Payment Processing**: Handle payment methods and basket checkout
- **Caching Layer**: Redis integration for improved performance
- **Data Persistence**: MongoDB for reliable data storage
- **API Documentation**: Swagger/OpenAPI 3 integration
- **Input Validation**: Comprehensive request validation
- **Exception Handling**: Global exception handling with proper error responses

## Technologies

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data MongoDB**
- **Spring Data Redis**
- **Spring Cloud OpenFeign**
- **Swagger/OpenAPI 3**
- **Lombok**
- **Maven**
- **Docker & Docker Compose**

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Docker and Docker Compose

### Installation

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   ```

2. **Start the required services**

```bash
   docker-compose up -d
   ```

   This will start:
    - MongoDB on port 27017
    - Redis on port 6379

3. **Build the application**

```bash
   ./mvnw clean install
   ```

### Running the Application

1. **Using Maven**

   ```bash
   ./mvnw spring-boot:run
   ```

2. **Using Java**

   ```bash
   java -jar target/cart-0.0.1-SNAPSHOT.jar
   ```

The application will be available at `http://localhost:8080`

## API Documentation

Once the application is running, you can access the API documentation at:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Project Structure

```structure
src/
├── main/
│   ├── java/dev/raniery/shop/
│   │   ├── CartApplication.java           # Main application class
│   │   ├── client/                        # External API clients
│   │   │   ├── StoreClient.java           # Feign client for store API
│   │   │   └── response/                  # Response DTOs
│   │   ├── controller/                    # REST controllers
│   │   │   ├── BasketController.java      # Basket management endpoints
│   │   │   ├── ProductController.java     # Product endpoints
│   │   │   └── doc/                       # API documentation interfaces
│   │   ├── entity/                        # Domain entities
│   │   │   ├── Basket.java                # Shopping basket entity
│   │   │   ├── Product.java               # Product entity
│   │   │   ├── PaymentMethod.java         # Payment method enum
│   │   │   ├── Status.java                # Basket status enum
│   │   │   └── request/                   # Request DTOs
│   │   ├── exceptions/                    # Exception handling
│   │   ├── repository/                    # Data access layer
│   │   └── service/                       # Business logic layer
│   └── resources/
│       └── application.yml                # Application configuration
└── test/                                  # Test classes
```

## 🔧 Configuration

The application can be configured through `application.yml`:

```yaml
spring:
  application:
    name: shop-cart-service

  data:
    mongodb:
      host: localhost
      port: 27017
      database: cart-service

    redis:
      host: localhost
      port: 6379
      password: sa

  cache:
    redis:
      time-to-live: 60000

shop:
  client:
    platzi: https://api.escuelajs.co/api/v1
```

## 🐳 Docker Support

The project includes Docker Compose configuration for easy development setup:

- **MongoDB**: Document database for data persistence
- **Redis**: In-memory cache for improved performance