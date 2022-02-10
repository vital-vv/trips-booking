package com.example.demo.tripbookingapi.domain.base;

import com.example.demo.tripbookingapi.domain.enumeration.Language;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractTranslatable extends AbstractAuditable {

  @Column(name = "language", nullable = false, length = 2)
  @Enumerated(EnumType.STRING)
  private Language language;
}
