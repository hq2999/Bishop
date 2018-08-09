package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CODE_USER database table.
 * 
 */
@Entity
@Table(name="CODE_USER")
@NamedQuery(name="CodeUser.findAll", query="SELECT c FROM CodeUser c")
public class CodeUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	private String address;

	private String enabled;

	@Column(name="FORCE_PASS")
	private String forcePass;

	private String kind;

	private String name;

	private String passwd;

	private String remarks;

	private String tel;

	public CodeUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getForcePass() {
		return this.forcePass;
	}

	public void setForcePass(String forcePass) {
		this.forcePass = forcePass;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}