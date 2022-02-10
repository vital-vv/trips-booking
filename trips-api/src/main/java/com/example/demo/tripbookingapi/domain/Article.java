package com.example.demo.tripbookingapi.domain;

import com.example.demo.tripbookingapi.domain.base.AbstractAuditable;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import com.example.demo.tripbookingapi.utils.TranslationUtils;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "articles")
public class Article extends AbstractAuditable {

  @Column(name = "image_id", length = 512)
  private String imageId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "trip_id", nullable = false)
  private Trip trip;

  @OneToMany(mappedBy = "article", orphanRemoval = true)
  @MapKey(name = "language")
  private Map<Language, ArticleTranslation> articleTranslations = new HashMap<>();

  public String getTitle(Language language) {
    return TranslationUtils.getTranslation(articleTranslations, language, ArticleTranslation::getTitle);
  }

  public String getText(Language language) {
    return TranslationUtils.getTranslation(articleTranslations, language, ArticleTranslation::getText);
  }
}
