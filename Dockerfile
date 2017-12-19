FROM openjdk:8u151-jdk

ADD . /RahanSazehApiServer

RUN \
    cd /RahanSazehApiServer && \
    rm -f gradle.properties

RUN \
    cd /RahanSazehApiServer && \
    ./gradlew bootRepackage

# heroku does not support EXPOSE
# EXPOSE 3000

WORKDIR /RahanSazehApiServer

# heroku does not support ENTRYPOINT
#ENTRYPOINT ["/RahanSazehApiServer/gradlew", "bootRun"]

CMD /RahanSazehApiServer/gradlew bootRun

