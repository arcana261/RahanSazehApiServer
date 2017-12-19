FROM openjdk:8u151-jdk

ADD . /RahanSazehApiServer

RUN \
    cd /RahanSazehApiServer && \
    rm -f gradle.properties

RUN \
    cd /RahanSazehApiServer && \
    ./gradlew build

# heroku does not support EXPOSE
# EXPOSE 3000

WORKDIR /RahanSazehApiServer

# Run the image as a non-root user
RUN adduser -D arcana
USER arcana

# heroku does not support ENTRYPOINT
#ENTRYPOINT ["/RahanSazehApiServer/gradlew", "bootRun"]

CMD java -jar /RahanSazehApiServer/build/libs/RahanSazeh-ApiServer-0.1.0.jar

