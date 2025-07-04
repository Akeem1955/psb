

# Prime-Stack Bank Ltd. Customer Information Management System

This project is a Customer Information Management System for Prime-Stack Bank Ltd. It enables the bank to store, manage, and update customer information through a user-friendly web interface and provides a secure RESTful API for integration with third-party applications. The system supports full CRUD (Create, Read, Update, Delete) operations for customer records, including fields such as Customer ID, Name, Age, Address, and Work Sector. Data is persisted using Spring Data JPA, and the application runs on an embedded Apache Tomcat server.


## Features
- Add, view, update, and delete customer information
- Customer fields: ID, Name, Age, Address, Work Sector
- Web interface using Thymeleaf templates and Spring MVC
- RESTful API for third-party integration (CRUD operations)
- Data persistence using Spring Data (JPA)
- Embedded Apache Tomcat server


## Project Structure
```
src/
  main/
    java/com/prime_stack/customer_info/
      CustomerInfoApplication.java         # Main Spring Boot application
      controller/
        CustomerInfo.java                  # Controller for web requests (form & API)
        CustomerInfoServices.java          # Controller for Rest Api Endpoints
      model/
        Customer.java                      # Customer entity
        CustomerRepo.java                  # Repository interface
    resources/
      application.properties               # Spring Boot configuration
      schema.sql                           # Database schema
      static/style.css                     # CSS styles
      templates/customer_info.html         # Thymeleaf template (customer form)
  test/
    java/com/prime_stack/customer_info/
      CustomerInfoApplicationTests.java    # Test cases
```


## Getting Started

### Prerequisites
- Java 17 or later
- Maven 3.6+

### Build and Run
1. Clone the repository:
   ```sh
   git clone <your-repo-url>
   cd customer_info
   ```
2. Build the project:
   ```sh
   ./mvnw clean install
   ```
3. Run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
4. Open your browser and go to [http://localhost:8080](http://localhost:8080)

### Configuration
- Edit `src/main/resources/application.properties` for database and server settings.
- The database schema is initialized from `schema.sql`.


## Web App Customer Info

- `GET http://localhost:8080/psb/customer_info` — Get The Frontend For Storing The Customer Information
- `GET http://localhost:8080/psb/save_customer_info` — Saves Customer Information


## API Endpoints

The RESTful API exposes the following endpoints for customer management:

- `GET http://localhost:8080/psb/services/api/v1/search` — List all customers
- `GET http://localhost:8080/psb/services/api/v1/search/{id}` — Get customer by ID
- `POST http://localhost:8080/psb/services/api/v1/create` — Create a new customer
- `PUT http://localhost:8080/psb/services/api/v1/update/{id}` — Update customer details
- `DELETE http://localhost:8080/psb/services/api/v1/delete/{id}` — Delete a customer

All API responses are in JSON format. Ensure that transactions from the web form are committed to the database.


## Technologies Used
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Maven
- Apache Tomcat (embedded)

