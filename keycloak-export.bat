docker exec -it trips-booking-keycloak-1 /opt/jboss/keycloak/bin/standalone.sh ^
            -Djboss.socket.binding.port-offset=100 ^
            -Dkeycloak.migration.action=export ^
            -Dkeycloak.migration.provider=singleFile ^
            -Dkeycloak.migration.realmName=trips ^
            -Dkeycloak.migration.usersExportStrategy=REALM_FILE ^
            -Dkeycloak.migration.file=/opt/jboss/keycloak/imports/trips-realm.json
