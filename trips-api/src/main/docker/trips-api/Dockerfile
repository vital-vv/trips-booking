FROM openjdk:17-alpine

ARG JAR_FILE
ARG PORT='8080'
ARG HEALTH_URL=localhost:$PORT/actuator/health

ENV PORT=$PORT
ENV HEALTH_URL=$HEALTH_URL

RUN apk update && apk add curl jq
RUN mkdir /opt/demo-app
RUN addgroup -S demo && adduser -S demo -G demo
RUN chown demo:demo /opt/demo-app

USER demo
WORKDIR /opt/demo-app

COPY $JAR_FILE application.jar

EXPOSE $PORT
ENTRYPOINT java $JAVA_OPTS -jar application.jar
HEALTHCHECK --start-period=30s --interval=30s --timeout=15s --retries=3 \
  CMD (curl -sf $HEALTH_URL || echo '{}') | jq --exit-status '.status=="UP"' || exit 1
