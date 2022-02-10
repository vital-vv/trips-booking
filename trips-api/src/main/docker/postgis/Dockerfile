FROM postgis/postgis:14-3.2-alpine

WORKDIR /docker-entrypoint-initdb.d
COPY create-databases.sh .
RUN chmod +x create-databases.sh
