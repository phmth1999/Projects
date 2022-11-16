package com.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date_create")
	private Date date_create;
	
	@Column(name = "date_update")
	private Date date_update;
	
	@Column(name = "date_delete")
	private Date date_delete;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_create() {
		return date_create;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	public Date getDate_update() {
		return date_update;
	}
	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}
	public Date getDate_delete() {
		return date_delete;
	}
	public void setDate_delete(Date date_delete) {
		this.date_delete = date_delete;
	}
	
}
