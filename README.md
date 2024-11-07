# Garage Sale App Backend

This project serves as the backend for the Garage Sale App, built using Spring Boot. It provides APIs to manage user authentication, item listings, and appointment scheduling, with role-based access for sellers and buyers.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Environment Variables](#environment-variables)
  - [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
  - [Unit Testing](#unit-testing)
  - [Integration Testing](#integration-testing)
- [Docker Support](#docker-support)
- [Contributing](#contributing)

## Features

- **Google Authentication**: Provides Google OAuth2-based login and logout.
- **Role-Based Access Control**: Enforces role-based access (e.g., SELLER, BUYER).
- **Item Management**: Allows CRUD operations on items, with certain actions restricted to sellers.
- **Appointment Scheduling**: Allows buyers to schedule appointments with sellers and manage status updates.

## Technologies Used

- **Java** (JDK 17)
- **Spring Boot** 3.3.4
- **Spring Security** (OAuth2 with Google authentication)
- **Hibernate/JPA** for data persistence
- **PostgreSQL** as the database
- **Docker** for containerization
- **Swagger** for API documentation

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)** 17 or higher
- **Maven** for dependency management
- **PostgreSQL** for database (or Docker if running PostgreSQL in a container)
- **Docker and Docker Compose** (optional, for containerized deployment)

### Environment Variables

Create a `.env` file in the root directory to define the following environment variables:

      SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/gs_db
      SPRING_DATASOURCE_USERNAME=your_db_username
      SPRING_DATASOURCE_PASSWORD=your_db_password
      GOOGLE_CLIENT_ID=your_google_client_id
      GOOGLE_CLIENT_SECRET=your_google_client_secret
      JWT_SECRET=your_jwt_secret_key

### Running the Application
Install Dependencies:
-mvn clean install

Run with Maven:
-mvn spring-boot:run

Run with Docker:
-docker-compose up -d

### Project Structure
Here’s an overview of the project structure:

          ```plaintext
          src
          ├── main
          │   ├── java/in/rebcoder/gs_back
          │   │   ├── controllers         # REST controllers
          │   │   ├── models              # Entity classes
          │   │   ├── repositories        # JPA repositories
          │   │   ├── services            # Service layer with business logic
          │   │   └── config              # Security and application configurations
          │   └── resources
          │       ├── application.yml     # Application configuration
          │       └── db                  # Database-related files
          └── test                        # Test files (unit and integration)

### ER Diagram
![image](https://github.com/user-attachments/assets/879e1746-a397-47f2-a858-7139761e0e57)

### API Endpoints

Authentication Endpoints

            POST /auth/login - Google login.
            GET /auth/logout - Logout user.

Item Endpoints

            POST /items/create - Create a new item (for SELLER).
            GET /items/home/{homeId} - Retrieve items by home.
            PUT /items/{id} - Update item.
            DELETE /items/{id} - Delete item.
            GET /items/all - Get all items.

Appointment Endpoints

            POST /appointments - Schedule a new appointment.
            PUT /appointments/{id}/status - Update appointment status.

API Documentation

            Swagger documentation is available at:
            http://localhost:8080/swagger-ui/index.html

Testing

Unit Testing

        Unit tests validate service layer functionality, ensuring that business logic works as expected. Tests use mock objects for database interactions to prevent reliance on actual data.

Run all unit tests:

        -mvn test

Integration Testing
        
                Integration tests validate API endpoints and the overall flow, covering scenarios like item creation, appointment scheduling, and user authentication. Tests are located in src/test/java.

Docker Support
To run the backend with Docker, ensure Docker and Docker Compose are installed. The following commands are available:

Start the containers

      -docker-compose up -d
Stop and remove containers and volumes

      -docker-compose down -v

### Contributing
We welcome contributions! Feel free to open issues for suggestions or to submit pull requests for bug fixes and enhancements.
