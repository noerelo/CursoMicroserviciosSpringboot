#inicia con la imagen base que contiene Java runtime
FROM eclipse-temurin:17-jdk as build

# se agregar el jar del microservicio al contenedor
COPY target/reservations-0.0.1-SNAPSHOT.jar reservations-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/reservations-0.0.1-SNAPSHOT.jar"]