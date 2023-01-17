# User Management Documentation

This project aims to make a **test offer** to set up a user management application.

**NOTE**

The project is based on:
* Springboot setup
* Spring AOP for tracing requests
* the H2 database for a quick start
* OpenAPI-UI for the Swagger

Please see on Github:
* the source code of the project
* the postman collection

---
### Source code
To build the project from sources, you must install:
* Java 11
* Maven 3

After downloading the sources, we go to the command line directory and execute:
* mvn clean install
* mvn spring-boot:run

---
### Postman Links

GET method without parameter that returns the list of users :
* http://localhost:8080/api/users

POST method with user information for creation :
* http://localhost:8080/api/users
* Content of the Body in the raw :
```json
{
  "nom": "Khalifa",
  "dateNaissance": "12/03/2000",
  "paysResidence": "French",
  "telephone": "776589087",
  "genre": "Male",
  "email": "khalifa@gmail.com"
}
```

GET method with user id as parameter that returns a user :
* http://localhost:8080/api/users/1

PUT method with user id as parameter to update a user :
* http://localhost:8080/api/users/1
* Content of the Body in the raw :
```json
{
  "nom": "Khalifa",
  "dateNaissance": "12/03/2000",
  "paysResidence": "French",
  "telephone": "776589087",
  "genre": "Male",
  "email": "khalifa.ndiaye@gmail.com"
}
```

DELETE method with user id as parameter to delete a user :
* http://localhost:8080/api/users/1


