package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractAuditable;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country extends AbstractAuditable {

  @Column(name = "code", nullable = false, unique = true, length = 2)
  private String code;

  @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Catering> caterings = new LinkedHashSet<>();

  @OneToMany(mappedBy = "country", orphanRemoval = true)
  @MapKey(name = "language")
  private Map<Language, CountryTranslation> countryTranslations = new HashMap<>();
}
