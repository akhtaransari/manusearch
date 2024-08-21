
```markdown
# ManuSearch Application

## Overview

ManuSearch is a Spring Boot application for managing and querying suppliers based on various criteria such as location, nature of business, and manufacturing processes. It also includes authentication and user registration features.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven or Gradle
- A database (e.g., MySQL) configured in `application.properties`

### Running the Application

1. **Clone the repository:**

   ```bash
   git clone https://github.com/akhtaransari/manusearch.git
   cd ManuSearch
   ```

2. **Install dependencies:**

   ```bash
   mvn install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, if you have a pre-built JAR file:

   ```bash
   java -jar target/ManuSearch-0.0.1-SNAPSHOT.jar
   ```

   The application will start on [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Authentication

#### User Login

- **URL:** `/api/auth/login`
- **Method:** GET
- **Description:** Retrieves the authentication details of the currently logged-in user.
- **Headers:**
  - `Authorization: Bearer <your-token>`
- **Example using Axios:**

  ```javascript
  const axios = require('axios');

  axios.get('http://localhost:8080/api/auth/login', {
    headers: {
      'Authorization': 'Bearer <your-token>'
    }
  })
  .then(response => console.log(response.data))
  .catch(error => console.error(error));
  ```

#### User Registration

- **URL:** `/api/auth/register`
- **Method:** POST
- **Description:** Registers a new user and saves their details to the database.
- **Request Body:**

  ```json
  {
    "email": "user@example.com",
    "password": "password123"
  }
  ```

- **Example using Axios:**

  ```javascript
  const axios = require('axios');

  axios.post('http://localhost:8080/api/auth/register', {
    email: 'user@example.com',
    password: 'password123'
  })
  .then(response => console.log(response.data))
  .catch(error => console.error(error));
  ```

### Supplier Management

#### Query Suppliers

- **URL:** `/api/supplier/query`
- **Method:** POST
- **Description:** Queries suppliers based on location, nature of business, and manufacturing process.
- **Request Parameters:**
  - `location` (String) - The location of the supplier.
  - `natureOfBusiness` (NatureOfBusiness enum) - The nature of the business.
  - `manufacturingProcess` (ManufacturingProcess enum) - The manufacturing process used by the supplier.
  - `page` (int, default 0) - The page number for pagination.
  - `size` (int, default 10) - The number of results per page.

- **Example using Axios:**

  ```javascript
  const axios = require('axios');

  axios.post('http://localhost:8080/api/supplier/query', null, {
    params: {
      location: 'Test Location',
      natureOfBusiness: 'SMALL_SCALE',
      manufacturingProcess: 'MOULDING',
      page: 0,
      size: 10
    }
  })
  .then(response => console.log(response.data))
  .catch(error => console.error(error));
  ```

## Testing

The application includes unit tests for various components to ensure functionality and reliability. 

### Running Tests

1. **Run unit tests:**

   ```bash
   mvn test
   ```

   This command executes all unit tests defined in the project. Ensure all dependencies are correctly set up and the application context is properly loaded for the tests to pass.

2. **Test Coverage:**

   Test coverage is measured and reports can be generated to ensure code quality. Use:

   ```bash
   mvn test jacoco:report
   ```

   Coverage reports can be found in `target/site/jacoco`.

### Test Details

- **Unit Tests:**
  - **Service Layer:** Tests the `SupplierServiceImpl` methods to verify correct behavior when interacting with the `SupplierRepository`.
  - **Controller Layer:** Tests the `AuthController` and `SupplierController` endpoints to ensure they handle requests and responses as expected.

- **Mocking Framework:** Mockito is used to mock the `SupplierRepository` and other dependencies to isolate tests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

For any issues or questions, please contact the project maintainer or open an issue in the GitHub repository.
```

### Key Points in the README

- **Getting Started:** Instructions for cloning, installing, and running the application.
- **API Endpoints:** Detailed description and usage examples for each endpoint, including authentication and supplier management.
- **Testing:** Instructions for running tests, checking coverage, and details about the testing framework and coverage reports.
- **License and Contact:** Licensing information and contact details for issues or questions.

Feel free to adjust the details and examples based on your actual project setup and requirements.
