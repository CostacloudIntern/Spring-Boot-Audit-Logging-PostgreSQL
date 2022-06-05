package com.postgresql.audit.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@EqualsAndHashCode
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

	@Column(name = "created_date", updatable = false)
	@Temporal(TIMESTAMP)
	@CreatedDate
    protected Date creationDate;


	@Column(name = "lastMod_date")
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date lastModifiedDate;

	@CreatedBy
	@Column(name="created_by")
	protected T createdBy;

	@LastModifiedBy
	@Column(name="modified_by")
	protected T modifiedBy;

	
	public Auditable() {
		super();
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public T getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(T createdBy) {
		this.createdBy = createdBy;
	}

	public T getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(T modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Auditable(Date creationDate, Date lastModifiedDate, T createdBy, T modifiedBy) {
		super();
		this.creationDate = creationDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}
	
	

}
