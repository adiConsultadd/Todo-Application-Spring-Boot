# Todo Backend with Spring Boot, MySQL, and JPA

## Prerequisites
Before starting, make sure you have:
- **Java Development Kit (JDK) 17** or later installed
- **MySQL** installed and running
- **Maven** installed (or use the included Maven wrapper)
- **An IDE** like IntelliJ IDEA, Eclipse, or VS Code

## Database Setup
1. Open MySQL command line or a tool like MySQL Workbench.
2. Run the following SQL commands to create the database and user:
   ```sql
   CREATE DATABASE tododb;
   CREATE USER 'todo_user'@'localhost' IDENTIFIED BY 'password';
   GRANT ALL PRIVILEGES ON tododb.* TO 'todo_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

## Creating the Project
There are two ways to create a Spring Boot project:

### Option 1: Using Spring Initializr (Recommended for beginners)
1. Go to [Spring Initializr](https://start.spring.io/)
2. Fill in the fields as follows:
    - Project: **Maven**
    - Language: **Java**
    - Spring Boot: **Latest stable version**
    - Dependencies: **Spring Web, Spring Data JPA, MySQL Driver**
3. Click **Generate**, download and extract the ZIP file.
4. Open the project in your IDE.

### Option 2: Using the Command Line
If you have Spring Boot CLI installed, run:
```bash
spring init --dependencies=web,data-jpa,mysql -n todo-backend
```

## Folder Structure
```
todo-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── todo_backend/
│   │   │               ├── TodoBackendApplication.java
│   │   │               ├── controller/
│   │   │               │   └── TodoController.java
│   │   │               ├── model/
│   │   │               │   └── Todo.java
│   │   │               ├── repository/
│   │   │               │   └── TodoRepository.java
│   │   │               └── service/
│   │   │                   ├── TodoService.java
│   │   │                   └── TodoServiceImpl.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── todobackend/
│                       └── TodoBackendApplicationTests.java
└── pom.xml
```

## Configuring the Database Connection
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=todo_user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application
Open a terminal in the project directory and run:
```bash
./mvnw spring-boot:run   # For Mac/Linux
mvnw.cmd spring-boot:run  # For Windows
```
The application will start on **port 8080**.

## API Endpoints
Use **Postman**, `curl`, or your browser to test the endpoints:
1. **Get all todos**: `GET http://localhost:8080/api/todos`
2. **Create a new todo**: `POST http://localhost:8080/api/todos`
3. **Get a specific todo by ID**: `GET http://localhost:8080/api/todos/{id}`
4. **Update a todo**: `PUT http://localhost:8080/api/todos/{id}`
5. **Delete a todo**: `DELETE http://localhost:8080/api/todos/{id}`
6. **Get todos by completion status**: `GET http://localhost:8080/api/todos/status?completed=true|false`
7. **Search todos by title**: `GET http://localhost:8080/api/todos/search?title=keyword`

## Key Spring Boot Concepts
- **Annotations**: `@RestController`, `@Service`, `@Repository`, etc.
- **Dependency Injection**: Spring provides instances where needed.
- **JPA/Hibernate**: Handles database operations automatically.
- **REST Controllers**: Create API endpoints.


