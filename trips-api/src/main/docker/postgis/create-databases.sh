#!/bin/sh

if [ -n "$POSTGRES_DATABASES" ]; then
  for database in $(echo "$POSTGRES_DATABASES" | tr ',' ' '); do
    echo "Creating database '$database'"
    psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE "$database" OWNER "$POSTGRES_USER";
EOSQL
  done
fi
