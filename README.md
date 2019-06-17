# Mastermind Application

This api has been implemented with following frameworks and tools:
  - Java 8
  - Spring Boot 1.5.19.RELEASE
  - Gradle
  - Swagger 2.7.0
  - MongoDB

# Launch application!
You can launch application with docker compose by command line:
For launch application you can run : 
```sh
$ docker-compose up -d
```
or with gradle task:
```sh
$ gradle buildContainer
$ gradle upContainer
```

and stop with:
```sh
$ gradle downContainer
```
or 
```sh
$ docker-compose down
```
Database mongo url: 
_`mongodb://mastermind-mongo:27017/mastermindmongo`_

And access to swagger (API Documentation and test) http://localhost:8080/swagger-ui.html

You can use swagger api to see endpoint and try it.

Endpoints:

 - Create new game -> `http://localhost:8080/game`  
 - Check colour sequence -> `http://localhost:8080/game/check`  
 - Get game info -> `http://localhost:8080/game/{id}`
 - Get game list (GET) -> `http://localhost:8080/game`  
 - Get game history -> `http://localhost:8080/game/history/{game}`

File **Mastermind.postman_collection.json** contains postman example to test api.

