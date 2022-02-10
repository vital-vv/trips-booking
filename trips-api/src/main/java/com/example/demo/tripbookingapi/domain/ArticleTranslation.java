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
@Table(name = "articles_translations", uniqueConstraints = {
    @UniqueConstraint(name = "uc_articletranslation", columnNames = {"article_id", "language"})
})
public class ArticleTranslation extends AbstractTranslatable {

  @Column(name = "title", nullable = false, length = 64)
  private String title;

  @Lob
  @Column(name = "text")
  private String text;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "article_id", nullable = false)
  private Article article;

}
