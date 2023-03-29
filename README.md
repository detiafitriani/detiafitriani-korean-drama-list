# korean-drama-list
## This project is a CRUD (Create-Read-Update-Delete) application for managing data of Korean Drama List databse. 
The project is built using Java language with Spring Boot and Maven, and uses PostgreSQL for database management.

## Prerequisites

- Java JDK 11 or higher 
- Spring Boot 
- Maven 
- Postgresql

## Getting Started
Setting up the Database
1. Create a new database in PostgreSQL.
2. Open the application.properties file located in the src/main/resources directory.
3. Initialize your port 
```shell script
.# application.properties
server.port={your port}
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/{database_name}
quarkus.datasource.username={username}
quarkus.datasource.password={password}
```
4. Replace the quarkus.datasource.jdbc.url property with the JDBC URL for your PostgreSQL database.
5.  Replace the quarkus.datasource.username and quarkus.datasource.password properties with your PostgreSQL username and password, respectively.

## Running the Application
1. Clone the repository to your local machine.

2. Navigate to the project directory in your terminal.

3. Run the following command to build the project:
```shell script
./mvn clean package
```
4.Once the build is complete, run the following command to start the application:
```shell script
mvn spring-boot:run
```
Replace {project-name} with the name of your project.

5. The application will now be running on http://localhost:{your port}.


# Endpoints
## Korean Drama List Management Endpoints


## GET /dramas
Returns a list of all Dramas in the database.

## GET /dramas/{id}
Returns the details of the Dramas with the specified ID.

## GET /dramas/titles/{title}
Returns the details of the Dramas with the specified Title.

## POST /dramas
Creates a new Drama. The request body should contain the Dramas data in JSON format.

## PUT /dramas/{id}
Updates the details of the Drama with the specified ID. The request body should contain the updated Drama data in JSON format.

## DELETE /dramas/{id}
Deletes the Drama with the specified ID.




















