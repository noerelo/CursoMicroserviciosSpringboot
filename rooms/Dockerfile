#inicia con la imagen base que contiene Java runtime
FROM eclipse-temurin:17-jdk as build

# se agregar el jar del microservicio al contenedor
COPY target/rooms-0.0.1-SNAPSHOT.jar rooms-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/rooms-0.0.1-SNAPSHOT.jar"]