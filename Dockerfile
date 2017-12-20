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
    rm -rfv /RahanSazehApiServer && \
    rm -rfv /root/.gradle
    mkdir -p /RahanSazehApiServer && \
    mv /RahanSazeh-ApiServer.jar /RahanSazehApiServer/ && \
    chmod -R 644 /RahanSazehApiServer


# heroku does not support EXPOSE
# EXPOSE 3000

WORKDIR /RahanSazehApiServer

# Run the image as a non-root user
RUN useradd -M -s /bin/false arcana
USER arcana

# heroku does not support ENTRYPOINT
#ENTRYPOINT ["/RahanSazehApiServer/gradlew", "bootRun"]

CMD java -jar /RahanSazehApiServer/RahanSazeh-ApiServer-0.1.0.jar

