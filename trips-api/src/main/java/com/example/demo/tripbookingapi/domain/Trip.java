package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractAuditable;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import com.example.demo.tripbookingapi.domain.enumeration.TripType;
import com.example.demo.tripbookingapi.utils.Geom;
import com.example.demo.tripbookingapi.utils.TranslationUtils;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;

@Getter
@Setter
@Entity
@Table(name = "trips")
public class Trip extends AbstractAuditable {

  @Column(name = "region", columnDefinition = Geom.POLYGON, nullable = false)
  private Polygon region;

  @Column(name = "image_id", length = 512)
  private String imageId;

  @Column(name = "rating")
  private Float rating;

  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private TripType type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

  @OneToMany(mappedBy = "trip", orphanRemoval = true)
  private Set<Article> articles = new LinkedHashSet<>();

  @OneToMany(mappedBy = "trip", orphanRemoval = true)
  @MapKey(name = "language")
  private Map<Language, TripTranslation> tripTranslations = new HashMap<>();

  public String getName(Language language) {
    return TranslationUtils.getTranslation(tripTranslations, language, TripTranslation::getName);
  }

  public String getDescription(Language language) {
    return TranslationUtils.getTranslation(tripTranslations, language, TripTranslation::getDescription);
  }

  public String getSpecification(Language language) {
    return TranslationUtils.getTranslation(tripTranslations, language, TripTranslation::getSpecification);
  }

  public String getCuisine(Language language) {
    return TranslationUtils.getTranslation(tripTranslations, language, TripTranslation::getCuisine);
  }
}
