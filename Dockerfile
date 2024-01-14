FROM bellsoft/liberica-openjdk-alpine
LABEL env=run
ENV TARGET_RUNTIME MAIN

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} eduback.jar

EXPOSE 80

RUN addgroup -S --gid 1234 guest_grp \
&& adduser --uid 1234 --system --ingroup guest_grp guest_usr

USER guest_usr

ENTRYPOINT ["java","-XX:MaxRAMPercentage=75.0","-jar","/eduback.jar","--spring.config.location=file:///spring-config/application.yaml"]