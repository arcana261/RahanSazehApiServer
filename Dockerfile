FROM openjdk:8u151-jdk

RUN \
    cd / && \
    git clone https://github.com/arcana261/RahanSazehApiServer.git && \
    cd /RahanSazehApiServer && \
    git checkout -b new-version origin/new-version && \
    rm -f gradle.properties && \
    ./gradlew build && \
    mv /RahanSazehApiServer/build/libs/RahanSazeh-ApiServer-0.1.0.jar /RahanSazeh-ApiServer.jar && \
    cd / && \
    rm -rf /RahanSazehApiServer && \
    rm -rf /root/.gradle && \
    mkdir -p /RahanSazehApiServer && \
    mv /RahanSazeh-ApiServer.jar /RahanSazehApiServer/ && \
    chmod -R 755 /RahanSazehApiServer && \
    useradd -M -s /bin/false arcana

# heroku does not support EXPOSE
# EXPOSE 3000

WORKDIR /RahanSazehApiServer

# Run the image as a non-root user
USER arcana

CMD java -jar /RahanSazehApiServer/RahanSazeh-ApiServer.jar

