FROM ubuntu:20.04

RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    maven \
    pandoc \
    && apt-get clean

WORKDIR /app

COPY . /app

RUN mvn clean package

CMD ["nohup", "sh", "target/bin/simplewebapp", "&"]
