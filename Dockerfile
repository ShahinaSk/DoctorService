FROM openjdk:11.0.3-jdk-stretch

ADD ./target/doctor-0.0.1-SNAPSHOT.jar /doctor/app/doctor-0.0.1-SNAPSHOT.jar

WORKDIR /doctor/app

ENTRYPOINT ["java","-jar","doctor-0.0.1-SNAPSHOT.jar"]