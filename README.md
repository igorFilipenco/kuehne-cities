# kuehne-cities

Application which was developed as test assignment

### Software to install:

- Java11
- Maven
- Git
- Postman
- Terminal

### Project tech stack:
- Java
- Spring-Boot
- Spring-Data-JPA
- Junit5
- Mockito
- H2-database


### Setup:

* Clone repository
* In terminal go do project root folder and build project with Maven with command `mvn clean install`
* Start Spring-boot aplication using command `mvn spring-boot:run`. Great we started the project!
* Import collection from `src/main/resources/file/kuehneApp.postman_collection.json` to Postman
* Execute POST request(this will populate data base. 
  You can access db on (http://localhost:8080/h2-console) user: admin, password: admin
* Now you can execute other requests to get, edit cities, or you can proceed to quickly-built [frontend part](https://github.com/igorFilipenco/kuehne-cities-frontend). Instructions about frontend setup can be found in frontend repository 
