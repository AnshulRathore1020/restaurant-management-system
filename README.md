# 🍽️ Restaurant Management System

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white)](https://spring.io)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://mysql.com)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)](https://docker.com)

A full-stack restaurant management application with role-based access control, dynamic menu management, and automated reservation handling.

## ✨ Features
- 🔐 Role-based access control (Admin / Staff / Customer)
- 🍕 Menu management — add, edit, delete items
- 📅 Reservation booking & management
- 🛡️ Spring Security integration for data protection
- 🐳 Dockerized for consistent deployment
- 📊 Optimized relational schema via Hibernate/JPA

## 🛠️ Tech Stack
| Layer | Technology |
|-------|-----------|
| Backend | Java 17, Spring Boot 3.x |
| ORM | Hibernate / Spring Data JPA |
| Frontend | Thymeleaf |
| Database | MySQL |
| Security | Spring Security |
| DevOps | Docker |
| Build Tool | Maven |

## 🚀 Getting Started

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.8+
- Docker (optional)

### Run Locally
```bash
# Clone the repo
git clone https://github.com/AnshulRathore1020/restaurant-management-system

# Configure DB in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

# Run the app
mvn spring-boot:run
```

### Run with Docker
```bash
docker-compose up --build
```
App will be available at `http://localhost:8080`

## 📸 Screenshots
<!-- Add screenshots here after taking them -->

## 🤝 Connect
Made with ❤️ by [Anshul Rathore](https://www.linkedin.com/in/anshul-rathore-it/)
