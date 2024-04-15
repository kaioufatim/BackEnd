FROM amazoncorretto:17
VOLUME /tmp
COPY dummy.txt project.jar
ENTRYPOINT ["java","-jar","project.jar"]
