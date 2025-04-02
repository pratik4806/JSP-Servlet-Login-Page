# Registration and Login System with JSP and Servlets

## Overview
This is a simple user registration and login system built using JSP, Servlets, and MySQL. Users can register with their details and log in to their profiles.

## Technologies Used
- Java (JSP & Servlets)
- MySQL
- Jakarta EE
- HTML, CSS

## Setup Instructions

### Prerequisites
- JDK 11 or later
- Apache Tomcat 9 or later
- MySQL Server
- Eclipse/IntelliJ IDEA (Optional for development)

### Database Configuration
1. Create a MySQL database named `yt_demo`.
2. Use the following SQL script to create the required table:

```sql
CREATE TABLE register (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL
);
```

### Configuration Changes
Update the database connection details in `Register.java` and `Login.java` files:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/yt_demo?useSSL=false&allowPublicKeyRetrieval=true";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "your_password";
```

### Running the Project
1. Import the project into Eclipse/IntelliJ IDEA.
2. Configure Apache Tomcat as the server.
3. Deploy the project and start the Tomcat server.
4. Access the application:
   - Registration Page: `http://localhost:8080/register.jsp`
   - Login Page: `http://localhost:8080/login.jsp`

## Features
- User Registration with Name, Email, Password, Gender, and City.
- Secure password storage using hashing (recommended enhancement).
- User login authentication.
- Session management using HttpSession.

## Security Considerations
- Use password hashing before storing credentials in the database.
- Use HTTPS for secure data transmission.
- Implement prepared statements to prevent SQL injection.


