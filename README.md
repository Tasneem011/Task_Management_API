# Task_Management_API
This is a Task Management API built with Spring Boot. It provides endpoints for creating, reading, updating, and deleting tasks. It uses JWT for security, and Swagger for interactive API documentation. The project is designed using the DTO pattern, tested using JUnit and Mockito, and utilizes Spring Data JPA with Hibernate for data persistence.
Features
1-CRUD operations for Tasks: Create, retrieve, update, and delete tasks.
2-User Authentication with JWT: Secure the API using JWT for user authentication.
3-DTO (Data Transfer Objects): Separate business logic from the entity model.
4-Unit and Integration Testing: Tested with JUnit and Mockito.
5-Swagger API Documentation: Explore API endpoints interactively.
6-Spring Security with JWT: Secure the endpoints with token-based authentication.
7-Lombok Integration: Use Lombok to reduce boilerplate code in the entity and service layers.
8-JPA and Hibernate: ORM for database interactions with Spring Data JPA.
9-Mockito: For testing service layers and mocking dependencies.
Technologies Used
Java 17 or higher
Spring Boot for building the API
Spring Security for securing endpoints with JWT
Spring Data JPA and Hibernate for database interaction
Swagger for API documentation
Lombok for reducing boilerplate code
JWT (JSON Web Token) for secure authentication
JUnit and Mockito for unit and integration testing
MySQL for database
MAP STRUCT 
Maven for dependencies
git clone https://github.com/Tasneem011/Task_Management-api.git
swagger link to view http://localhost:8080/swagger-ui/index.html#/Task%20API/createTask

When uploading your Task Management API project to GitHub, you should include a comprehensive README.md file that clearly explains what your project does, the technologies used, and how to set it up. Since your project includes various advanced features like Spring Boot, JWT for security, Swagger for API documentation, DTO, testing with Mockito, and more, it's important to detail these so others can easily understand your work.

Here’s a detailed structure you can follow for your README.md file:

Task Management API
This is a Task Management API built with Spring Boot. It provides endpoints for creating, reading, updating, and deleting tasks. It uses JWT for security, and Swagger for interactive API documentation. The project is designed using the DTO pattern, tested using JUnit and Mockito, and utilizes Spring Data JPA with Hibernate for data persistence.

Features
CRUD operations for Tasks: Create, retrieve, update, and delete tasks.
User Authentication with JWT: Secure the API using JWT for user authentication.
DTO (Data Transfer Objects): Separate business logic from the entity model.
Unit and Integration Testing: Tested with JUnit and Mockito.
Swagger API Documentation: Explore API endpoints interactively.
Spring Security with JWT: Secure the endpoints with token-based authentication.
Lombok Integration: Use Lombok to reduce boilerplate code in the entity and service layers.
JPA and Hibernate: ORM for database interactions with Spring Data JPA.
Mockito: For testing service layers and mocking dependencies.
Technologies Used
Java 17 or higher
Spring Boot for building the API
Spring Security for securing endpoints with JWT
Spring Data JPA and Hibernate for database interaction
Swagger for API documentation
Lombok for reducing boilerplate code
JWT (JSON Web Token) for secure authentication
JUnit and Mockito for unit and integration testing
MySQL for database

Prerequisites
Java 17 or higher
Maven for dependency management
MySQL for production or H2 for development
Docker (if using containerization)
Setup and Installation
1. Clone the Repository
bash
Copy code
git clone https://github.com/<your-github-username>/task-management-api.git
cd task-management-api
2. Configure the Database
Update the application.properties file for your preferred database configuration:

For MySQL:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


properties
Copy code
spring.datasource.url=jdbc:h2:mem:task_db
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
3. Build the Application
Using Maven:

bash
Copy code
mvn clean install
4. Run the Application
bash
Copy code
mvn spring-boot:run
Or use the packaged .jar file:

bash
Copy code
java -jar target/task-management-api.jar
5. Access Swagger UI
After running the application, access the Swagger documentation at:

bash
Copy code
http://localhost:8080/swagger-ui.html
API Endpoints
Here are some of the main API endpoints:

POST /api/v1/auth/login: Authenticate a user and get JWT token
POST /api/tasks: Create a new task
GET /api/tasks: Get all tasks
GET /api/tasks/{id}: Get a task by ID
PUT /api/tasks/{id}: Update a task
DELETE /api/tasks/{id}: Delete a task

