FROM openjdk:8u151-jdk

RUN \
    apt-get update && \
    apt-get install -y git

RUN \
    cd / && \
    git clone https://github.com/arcana261/RahanSazehApiServer.git && \
    cd RahanSazehApiServer && \
    git checkout -b new-version origin/new-version && \
    rm -f gradle.properties && \
    ./gradlew bootRepackage && \
    ./gradlew jar

EXPOSE 3000

WORKDIR /RahanSazehApiServer
ENTRYPOINT ["/RahanSazehApiServer/gradlew", "bootRun"]
