FROM openjdk:11

MAINTAINER Khalifa ndiaye.khalifa@gmail.com

ARG JAR_FILE=*.jar

#WORKDIR /opt/gestion-users

COPY ${JAR_FILE} gestion-users.jar

EXPOSE 8280

#COPY entrypoint.sh entrypoint.sh

RUN chmod 755 entrypoint.sh

#ENTRYPOINT ["./entrypoint.sh"]
ENTRYPOINT ["java", "-jar", "gestion-users.jar"]
