package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractTranslatable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "caterings_translations", uniqueConstraints = {
    @UniqueConstraint(name = "uc_cateringtranslation", columnNames = {"catering_id", "language"})
})
public class CateringTranslation extends AbstractTranslatable {

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "catering_id", nullable = false)
  private Catering catering;

}
