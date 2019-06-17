# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY ./mastermind-api/build/libs/mastermind-api-1.0.0-SNAPSHOT.jar /mastermind.jar
# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/mastermind.jar"]
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh