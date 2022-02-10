package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractAuditable;
import com.example.demo.tripbookingapi.domain.enumeration.CateringType;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
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

@Getter
@Setter
@Entity
@Table(name = "caterings")
public class Catering extends AbstractAuditable {

  @Column(name = "type", nullable = false, length = 16)
  @Enumerated(EnumType.STRING)
  private CateringType type;

  @Column(name = "image_id", length = 512)
  private String imageId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

  @OneToMany(mappedBy = "catering", orphanRemoval = true)
  @MapKey(name = "language")
  private Map<Language, CateringTranslation> cateringTranslations = new HashMap<>();

}
