FROM openjdk:8
EXPOSE 8080
ADD target/orderservice-dockercodpip.jar orderservice-dockercodpip.jar
ENTRYPOINT ["java", "-jar", "/orderservice-dockercodpip.jar"]
