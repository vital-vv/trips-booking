package com.example.demo.tripbookingapi.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class JwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

  @Override
  public Collection<GrantedAuthority> convert(Jwt source) {
    final Stream<String> realmRoles = getRealmRoles(source);
    final Stream<String> clientRoles = getClientRoles(source);

    return Stream.concat(realmRoles, clientRoles)
        .distinct()
        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
        .collect(Collectors.toList());
  }

  private Stream<String> getRealmRoles(Jwt jwt) {
    return getRoles(jwt.getClaim("realm_access"));
  }

  private Stream<String> getClientRoles(Jwt jwt) {
    final Map<String, Map<String, Collection<String>>> resourceAccess = jwt.getClaim("resource_access");

    return Optional.ofNullable(resourceAccess)
        .stream()
        .map(Map::values)
        .flatMap(Collection::stream)
        .flatMap(this::getRoles);
  }

  private Stream<String> getRoles(@Nullable Map<String, Collection<String>> access) {
    return access != null
        ? access.getOrDefault("roles", Collections.emptyList()).stream()
        : Stream.empty();
  }
}
