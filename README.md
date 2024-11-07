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

```plaintext
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/gs_db
SPRING_DATASOURCE_USERNAME=your_db_username
SPRING_DATASOURCE_PASSWORD=your_db_password
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret
JWT_SECRET=your_jwt_secret_key
