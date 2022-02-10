package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractTranslatable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trips_translations", uniqueConstraints = {
    @UniqueConstraint(name = "uc_triptranslation", columnNames = {"trip_id", "language"})
})
public class TripTranslation extends AbstractTranslatable {

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "description", length = 128)
  private String description;

  @Column(name = "cuisine", length = 512)
  private String cuisine;

  @Lob
  @Column(name = "specification")
  private String specification;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "trip_id", nullable = false)
  private Trip trip;

}
