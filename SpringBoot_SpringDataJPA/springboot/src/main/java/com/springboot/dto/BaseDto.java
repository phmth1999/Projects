package com.springboot.dto;

import java.util.Date;

public abstract class BaseDto {
	private int id;
	private Date date_create;
	private Date date_update;
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
