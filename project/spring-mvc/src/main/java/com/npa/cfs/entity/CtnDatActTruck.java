package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CTN_DAT_ACT_TRUCK database table.
 * 
 */
@Entity
@Table(name="CTN_DAT_ACT_TRUCK")
@NamedQuery(name="CtnDatActTruck.findAll", query="SELECT c FROM CtnDatActTruck c")
public class CtnDatActTruck implements Serializable {
	private static final long serialVersionUID = 1L;

	private String containerno1;

	private String containerno2;

	private String containerno3;

	private String containerno4;

	private String ctnid3;

	private String ctnid4;

	private String ctnsizetype1;

	private String ctnsizetype2;

	private String ctnsizetype3;

	private String ctnsizetype4;

	@Column(name="DRIVER_INFO")
	private String driverInfo;

	@Column(name="INGATE_NO")
	private String ingateNo;

	@Column(name="INGATE_TIME")
	private String ingateTime;

	@Column(name="INGATE_USERID")
	private String ingateUserid;

	@Column(name="OUTGATE_NO")
	private String outgateNo;

	@Column(name="OUTGATE_TIME")
	private String outgateTime;

	@Column(name="OUTGATE_USERID")
	private String outgateUserid;

	private String remark;

	private String status;

	@Column(name="TRUCK_LICENSE")
	private String truckLicense;

	@Id
	private String truckcode;

	@Column(name="XD_MARK1")
	private String xdMark1;

	@Column(name="XD_MARK2")
	private String xdMark2;

	@Column(name="XD_MARK3")
	private String xdMark3;

	@Column(name="XD_MARK4")
	private String xdMark4;

	public CtnDatActTruck() {
	}

	public String getContainerno1() {
		return this.containerno1;
	}

	public void setContainerno1(String containerno1) {
		this.containerno1 = containerno1;
	}

	public String getContainerno2() {
		return this.containerno2;
	}

	public void setContainerno2(String containerno2) {
		this.containerno2 = containerno2;
	}

	public String getContainerno3() {
		return this.containerno3;
	}

	public void setContainerno3(String containerno3) {
		this.containerno3 = containerno3;
	}

	public String getContainerno4() {
		return this.containerno4;
	}

	public void setContainerno4(String containerno4) {
		this.containerno4 = containerno4;
	}

	public String getCtnid3() {
		return this.ctnid3;
	}

	public void setCtnid3(String ctnid3) {
		this.ctnid3 = ctnid3;
	}

	public String getCtnid4() {
		return this.ctnid4;
	}

	public void setCtnid4(String ctnid4) {
		this.ctnid4 = ctnid4;
	}

	public String getCtnsizetype1() {
		return this.ctnsizetype1;
	}

	public void setCtnsizetype1(String ctnsizetype1) {
		this.ctnsizetype1 = ctnsizetype1;
	}

	public String getCtnsizetype2() {
		return this.ctnsizetype2;
	}

	public void setCtnsizetype2(String ctnsizetype2) {
		this.ctnsizetype2 = ctnsizetype2;
	}

	public String getCtnsizetype3() {
		return this.ctnsizetype3;
	}

	public void setCtnsizetype3(String ctnsizetype3) {
		this.ctnsizetype3 = ctnsizetype3;
	}

	public String getCtnsizetype4() {
		return this.ctnsizetype4;
	}

	public void setCtnsizetype4(String ctnsizetype4) {
		this.ctnsizetype4 = ctnsizetype4;
	}

	public String getDriverInfo() {
		return this.driverInfo;
	}

	public void setDriverInfo(String driverInfo) {
		this.driverInfo = driverInfo;
	}

	public String getIngateNo() {
		return this.ingateNo;
	}

	public void setIngateNo(String ingateNo) {
		this.ingateNo = ingateNo;
	}

	public String getIngateTime() {
		return this.ingateTime;
	}

	public void setIngateTime(String ingateTime) {
		this.ingateTime = ingateTime;
	}

	public String getIngateUserid() {
		return this.ingateUserid;
	}

	public void setIngateUserid(String ingateUserid) {
		this.ingateUserid = ingateUserid;
	}

	public String getOutgateNo() {
		return this.outgateNo;
	}

	public void setOutgateNo(String outgateNo) {
		this.outgateNo = outgateNo;
	}

	public String getOutgateTime() {
		return this.outgateTime;
	}

	public void setOutgateTime(String outgateTime) {
		this.outgateTime = outgateTime;
	}

	public String getOutgateUserid() {
		return this.outgateUserid;
	}

	public void setOutgateUserid(String outgateUserid) {
		this.outgateUserid = outgateUserid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTruckLicense() {
		return this.truckLicense;
	}

	public void setTruckLicense(String truckLicense) {
		this.truckLicense = truckLicense;
	}

	public String getTruckcode() {
		return this.truckcode;
	}

	public void setTruckcode(String truckcode) {
		this.truckcode = truckcode;
	}

	public String getXdMark1() {
		return this.xdMark1;
	}

	public void setXdMark1(String xdMark1) {
		this.xdMark1 = xdMark1;
	}

	public String getXdMark2() {
		return this.xdMark2;
	}

	public void setXdMark2(String xdMark2) {
		this.xdMark2 = xdMark2;
	}

	public String getXdMark3() {
		return this.xdMark3;
	}

	public void setXdMark3(String xdMark3) {
		this.xdMark3 = xdMark3;
	}

	public String getXdMark4() {
		return this.xdMark4;
	}

	public void setXdMark4(String xdMark4) {
		this.xdMark4 = xdMark4;
	}

}