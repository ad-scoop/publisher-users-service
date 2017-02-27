FROM java:8-jdk-alpine

COPY build/distributions/publisher-users-service.zip /usr/lib/adscoop/publisher-users-service.zip

RUN apk update && apk upgrade
RUN apk add bash

RUN cd /usr/lib/adscoop/ && unzip publisher-users-service.zip
RUN rm /usr/lib/adscoop/publisher-users-service.zip

EXPOSE 8182

