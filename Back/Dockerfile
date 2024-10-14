FROM debian:latest

RUN apt-get update 
RUN apt-get install -y maven

COPY . /Back

WORKDIR /Back

EXPOSE 8000

CMD ["mvn", "spring-boot:run"]