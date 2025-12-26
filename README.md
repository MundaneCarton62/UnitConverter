# Unit Converter — v1.0 (MC62)

A simple **web-based Unit Converter** built with Spring Boot.
It allows users to convert values between different units such as **temperature, length, and weight**.

This project runs on **Java 8+** and is part of a collection of small projects made for fun and learning.
https://roadmap.sh/projects/unit-converter
---
## Features

- Convert between different unit types:
    - **Temperature**: Celsius, Fahrenheit, Kelvin
    - **Length**: Millimeter, Centimeter, Meter, Kilometer
    - **Weight**: Milligram, Gram, Kilogram, Ounce, Pound
- Persist selected values after conversion
- Simple UI using Thymeleaf
- Backend logic separated into a service layer
- Unit and controller tests included

---
## Tech Stack

- Java 17
- Spring Boot
- Spring MVC
- Thymeleaf
- JUnit 5
- MockMvc
- Maven
---
## How to Run

1. Clone the repository
2. Run the application:

```bash
mvn spring-boot:run   
```

3. Open your browser and go to:

http://localhost:8080/


---
## Tests

Run all tests with:

mvn test


The project includes:

Unit tests for conversion logic

Controller test to verify the home page loads correctly