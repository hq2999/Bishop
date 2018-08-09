package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CTN_DAT_CTNINFO_OTHER_OPT database table.
 * 
 */
@Entity
@Table(name="CTN_DAT_CTNINFO_OTHER_OPT")
@NamedQuery(name="CtnDatCtninfoOtherOpt.findAll", query="SELECT c FROM CtnDatCtninfoOtherOpt c")
public class CtnDatCtninfoOtherOpt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String createtime;

	@Column(name="CTN_SERIALNO")
	private String ctnSerialno;

	private String ctnno;

	@Column(name="DISPATCH_TIME")
	private String dispatchTime;

	@Column(name="FINISH_TIME")
	private String finishTime;

	@Column(name="OPT_CODE")
	private String optCode;

	@Column(name="OPT_NAME")
	private String optName;

	@Column(name="OPT_USER")
	private String optUser;

	private String worker;

	public CtnDatCtninfoOtherOpt() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCtnSerialno() {
		return this.ctnSerialno;
	}

	public void setCtnSerialno(String ctnSerialno) {
		this.ctnSerialno = ctnSerialno;
	}

	public String getCtnno() {
		return this.ctnno;
	}

	public void setCtnno(String ctnno) {
		this.ctnno = ctnno;
	}

	public String getDispatchTime() {
		return this.dispatchTime;
	}

	public void setDispatchTime(String dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	public String getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getOptCode() {
		return this.optCode;
	}

	public void setOptCode(String optCode) {
		this.optCode = optCode;
	}

	public String getOptName() {
		return this.optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getOptUser() {
		return this.optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public String getWorker() {
		return this.worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

}