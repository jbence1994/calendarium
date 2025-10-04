calendarium
===========

### Application for scheduling and managing appointments.

[![Continuous Integration](https://github.com/jbence1994/calendarium/actions/workflows/build.yaml/badge.svg)](https://github.com/jbence1994/calendarium/actions/workflows/build.yaml)

Prerequisites
-------------

To avoid any unexpected application behavior, make sure you have installed the following tools with the proper version
numbers:

- [Eclipse Temurin JDK 21](https://adoptium.net/temurin/releases/?version=21)
- [Maven 3.9.6](https://maven.apache.org/download.cgi)

Run project locally
-------------------

### Build application

```bash
mvn clean install
```

### Starting application with Spring Boot Maven plugin

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

- To try application endpoints, open http://localhost:8080/swagger-ui/index.html in your web browser.

- To view api documentation, open http://localhost:8080/v3/api-docs in your web browser.
