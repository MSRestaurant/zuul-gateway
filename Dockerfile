FROM java:8
EXPOSE 8093
ADD /target/Zuul-Gateway-0.0.1-SNAPSHOT.jar Zuul-Gateway.jar
ENTRYPOINT ["java","-jar","Zuul-Gateway.jar"]