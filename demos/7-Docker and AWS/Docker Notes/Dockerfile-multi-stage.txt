#Multi stage Dockerfile 
#Stage 1 will compile the project into a jar file 
#Stage 2 will be used as the "lightweight" distributable image format 

FROM maven:3.8.6-amazoncorretto-17 AS MAVEN_BUILD_STAGE

#Copy over all the files into our container 
COPY ./ ./ 

RUN mvn clean package 


#Distributable lightweight image 
FROM eclipse-temurin:17-jre

COPY --from=MAVEN_BUILD_STAGE ./target/Spring-backend-0.0.1-SNAPSHOT.jar ./demo.jar 

CMD ["java","-jar","/demo.jar"]
