FROM openjdk:11-jdk-slim

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    maven \
    pandoc \
    texlive \
    && apt-get clean

WORKDIR /app

COPY . /app

RUN mvn clean package

CMD ["nohup", "sh", "target/bin/simplewebapp", "&"]