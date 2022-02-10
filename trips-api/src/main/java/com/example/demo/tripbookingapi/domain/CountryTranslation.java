package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractTranslatable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries_translations", uniqueConstraints = {
    @UniqueConstraint(name = "uc_countrytranslation", columnNames = {"country_id", "language"})
})
public class CountryTranslation extends AbstractTranslatable {

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

}
