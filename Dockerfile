FROM openjdk:8u151-jdk

RUN \
    apt-get update && \
    apt-get install -y git && \
    git clone https://github.com/arcana261/RahanSazehApiServer.git && \
    cd RahanSazehApiServer && \
    git checkout -b new-version origin/new-version && \
    ./gradlew shadowJar


