package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CTN_CODE_MEGATHERMAL database table.
 * 
 */
@Entity
@Table(name="CTN_CODE_MEGATHERMAL")
@NamedQuery(name="CtnCodeMegathermal.findAll", query="SELECT c FROM CtnCodeMegathermal c")
public class CtnCodeMegathermal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="BEGIN_DATE")
	private String beginDate;

	@Column(name="END_DATE")
	private String endDate;

	private String remark;

	public CtnCodeMegathermal() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}