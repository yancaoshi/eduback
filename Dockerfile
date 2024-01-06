FROM alpine:latest
LABEL env=run
ENV TARGET_RUNTIME MAIN

RUN apk add openjdk17-jdk --update-cache --repository http://dl-cdn.alpinelinux.org/alpine/edge/community --allow-untrusted

COPY ["./eduback.jar", "eduback.jar"]

EXPOSE 8080

RUN addgroup -S --gid 1234 guest_grp \
&& adduser --uid 1234 --system --ingroup guest_grp guest_usr

USER guest_usr

ENTRYPOINT ["java","-XX:MaxRAMPercentage=75.0","-jar","/eduback.jar","--spring.config.location=file:///spring-config/application.yaml"]