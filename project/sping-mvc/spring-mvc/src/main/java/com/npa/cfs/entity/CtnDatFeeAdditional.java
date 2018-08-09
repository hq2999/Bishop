package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CTN_DAT_FEE_ADDITIONAL database table.
 * 
 */
@Entity
@Table(name="CTN_DAT_FEE_ADDITIONAL")
@NamedQuery(name="CtnDatFeeAdditional.findAll", query="SELECT c FROM CtnDatFeeAdditional c")
public class CtnDatFeeAdditional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String ctnid;

	private String ctnno;

	@Column(name="FEE_ID")
	private String feeId;

	@Column(name="FEE_NAME")
	private String feeName;

	@Column(name="FEE_VALUE")
	private String feeValue;

	@Column(name="OPT_DATE")
	private String optDate;

	@Column(name="OPT_TYPE")
	private String optType;

	@Column(name="OPT_USER")
	private String optUser;

	@Column(name="RECE_VALUE")
	private String receValue;

	private String times;

	private String unit;

	public CtnDatFeeAdditional() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCtnid() {
		return this.ctnid;
	}

	public void setCtnid(String ctnid) {
		this.ctnid = ctnid;
	}

	public String getCtnno() {
		return this.ctnno;
	}

	public void setCtnno(String ctnno) {
		this.ctnno = ctnno;
	}

	public String getFeeId() {
		return this.feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public String getFeeName() {
		return this.feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getFeeValue() {
		return this.feeValue;
	}

	public void setFeeValue(String feeValue) {
		this.feeValue = feeValue;
	}

	public String getOptDate() {
		return this.optDate;
	}

	public void setOptDate(String optDate) {
		this.optDate = optDate;
	}

	public String getOptType() {
		return this.optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getOptUser() {
		return this.optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public String getReceValue() {
		return this.receValue;
	}

	public void setReceValue(String receValue) {
		this.receValue = receValue;
	}

	public String getTimes() {
		return this.times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}