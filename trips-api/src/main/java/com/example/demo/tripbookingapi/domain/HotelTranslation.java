package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractTranslatable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hotels_translations")
public class HotelTranslation extends AbstractTranslatable {

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "description", length = 256)
  private String description;

  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "hotel_id", nullable = false)
  private Hotel hotel;

}
