FROM openjdk:11-jdk-slim

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    maven \
    pandoc \
    && apt-get clean

WORKDIR /app

COPY . /app

CMD ["nohup", "sh", "target/bin/simplewebapp", "&"]