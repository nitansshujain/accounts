package com.microservice.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//@EntityListeners(AuditingEntityListener.class) // ?
@MappedSuperclass // act as a super class for all my entities,whenever I'm trying to extend this base entity class
@Getter @Setter @ToString
@EntityListeners(AuditingEntityListener.class) // It is a class present in the Spring JPA framework
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false) // It will not allow to populate the value or update the value, means this field will not be updated when I try to update it.
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
