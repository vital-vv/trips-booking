package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractAuditable;
import com.example.demo.tripbookingapi.domain.enumeration.HotelFeature;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import com.example.demo.tripbookingapi.utils.Geom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
@Entity
@Table(name = "hotels")
public class Hotel extends AbstractAuditable {

  @Column(name = "rating")
  private Float rating;

  @Column(name = "location", columnDefinition = Geom.POINT, nullable = false)
  private Point location;

  @Column(name = "image_id", length = 512)
  private String imageId;

  // TODO discounts

  @ElementCollection
  @Column(name = "features")
  @CollectionTable(name = "hotels_features", joinColumns = @JoinColumn(name = "hotel_id"))
  private Set<HotelFeature> features = new LinkedHashSet<>();

  @OneToMany(mappedBy = "hotel", orphanRemoval = true)
  private List<Review> reviews = new ArrayList<>();

  @OneToMany(mappedBy = "hotel", orphanRemoval = true)
  @MapKey(name = "language")
  private Map<Language, HotelTranslation> hotelTranslations = new HashMap<>();

  // TODO rooms
}
