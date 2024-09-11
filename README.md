# Spring Boot Web API

This is a Spring Boot-based web API that provides a set of RESTful endpoints to interact with a database. It follows standard MVC architecture, providing services for performing CRUD operations on resources.

## Features

- RESTful API with full CRUD functionality
- Pagination and sorting for list endpoints
- Validation for request data
- Error handling with standardized responses
- Integration with a database using Spring Data JPA
- Support for Swagger API documentation
- Unit and integration tests

## Technologies Used

- **Java 1.8**
- **Spring Boot 2.x**
- **Spring Data JPA** - Database integration
- **MySQLL** - Database (depending on the environment)
- **Swagger** - API documentation
- **Maven** - Build tool
- **Lombok** - Build tool

## Prerequisites

To run this project, you need the following installed:

- **Java 1.5** or higher
- **A relational database** (MySQL, PostgreSQL)

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/GPAPD/springboot-pos-rest-api.git
    cd springboot-pos-rest-api
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Set up the database connection in `application.properties` or `application.yml`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

5. The API will be available at `http://localhost:8080`.

## Endpoints



### Swagger Documentation

After running the application, you can access the Swagger UI at:

