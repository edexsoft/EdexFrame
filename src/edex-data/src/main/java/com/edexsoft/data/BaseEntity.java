package com.edexsoft.data;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseEntity implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonIgnore
	private Date metaCreated;

	@JsonIgnore
	private Date metaUpdated;

	@JsonIgnore
	private Integer metaLogicFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMetaCreated() {
		return metaCreated;
	}

	public void setMetaCreated(Date metaCreated) {
		this.metaCreated = metaCreated;
	}

	public Date getMetaUpdated() {
		return metaUpdated;
	}

	public void setMetaUpdated(Date metaUpdated) {
		this.metaUpdated = metaUpdated;
	}

	public Integer getMetaLogicFlag() {
		return metaLogicFlag;
	}

	public void setMetaLogicFlag(Integer metaLogicFlag) {
		this.metaLogicFlag = metaLogicFlag;
	}

	public Object copy() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}