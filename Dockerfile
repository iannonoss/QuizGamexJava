# syntax=docker/dockerfile:1
FROM openjdk:11
RUN apt-get update
RUN apt install -y libxrender1 libxtst6 libxi6
ADD target/JavaQuiz-1.0-SNAPSHOT.jar .
ADD PlayerPoint.serr .
COPY out /out
CMD ["java","-jar", "JavaQuiz-1.0-SNAPSHOT.jar"]
#RUN java -jar JavaQuiz-1.0-SNAPSHOT.jar
