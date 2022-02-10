package com.example.demo.tripbookingapi.domain.base;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditable extends AbstractPersistable<Long> {

  @Version
  @Column(name = "version", nullable = false)
  protected Integer version;

  @CreatedDate
  @Column(name = "created_on", nullable = false, updatable = false)
  protected Instant createdOn;

  @CreatedBy
  @Column(name = "created_by", nullable = false, updatable = false, length = 96)
  protected String createdBy;

  @LastModifiedDate
  @Column(name = "updated_on", nullable = false)
  protected Instant updatedOn;

  @LastModifiedBy
  @Column(name = "updated_by", nullable = false, length = 96)
  protected String updatedBy;

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
