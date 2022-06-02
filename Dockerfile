FROM openjdk:11

COPY ./build/libs/products-api-0.0.1-SNAPSHOT.jar products-api-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "products-api-0.0.1-SNAPSHOT.jar"]