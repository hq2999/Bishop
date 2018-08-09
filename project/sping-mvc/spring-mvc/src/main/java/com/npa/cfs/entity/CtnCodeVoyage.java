package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CTN_CODE_VOYAGE database table.
 * 
 */
@Entity
@Table(name="CTN_CODE_VOYAGE")
@NamedQuery(name="CtnCodeVoyage.findAll", query="SELECT c FROM CtnCodeVoyage c")
public class CtnCodeVoyage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ATA_DATE")
	private String ataDate;

	@Column(name="ATD_DATE")
	private String atdDate;

	@Column(name="CLOSE_DATE")
	private String closeDate;

	@Column(name="\"ENABLE\"")
	private String enable;

	@Column(name="ENNAME_VSL")
	private String ennameVsl;

	@Column(name="ETA_DATE")
	private String etaDate;

	@Column(name="ETD_DATE")
	private String etdDate;

	private String remark;

	
	@Id
	@Column(name="UN_VSL")
	private String unVsl;

	private String voyage;

	@Column(name="WORK_TERMINAL")
	private String workTerminal;

	public CtnCodeVoyage() {
	}

	public String getAtaDate() {
		return this.ataDate;
	}

	public void setAtaDate(String ataDate) {
		this.ataDate = ataDate;
	}

	public String getAtdDate() {
		return this.atdDate;
	}

	public void setAtdDate(String atdDate) {
		this.atdDate = atdDate;
	}

	public String getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getEnnameVsl() {
		return this.ennameVsl;
	}

	public void setEnnameVsl(String ennameVsl) {
		this.ennameVsl = ennameVsl;
	}

	public String getEtaDate() {
		return this.etaDate;
	}

	public void setEtaDate(String etaDate) {
		this.etaDate = etaDate;
	}

	public String getEtdDate() {
		return this.etdDate;
	}

	public void setEtdDate(String etdDate) {
		this.etdDate = etdDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUnVsl() {
		return this.unVsl;
	}

	public void setUnVsl(String unVsl) {
		this.unVsl = unVsl;
	}

	public String getVoyage() {
		return this.voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getWorkTerminal() {
		return this.workTerminal;
	}

	public void setWorkTerminal(String workTerminal) {
		this.workTerminal = workTerminal;
	}

}