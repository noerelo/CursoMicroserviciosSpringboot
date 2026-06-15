#inicia con la imagen base que contiene Java runtime
FROM eclipse-temurin:17-jdk as build

# se agregar el jar del microservicio al contenedor
COPY target/gatewayserver-0.0.1-SNAPSHOT.jar gatewayserver-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/gatewayserver-0.0.1-SNAPSHOT.jar"]