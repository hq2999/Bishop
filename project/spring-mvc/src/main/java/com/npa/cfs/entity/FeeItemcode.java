package com.npa.cfs.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FEE_ITEMCODE database table.
 * 
 */
@Entity
@Table(name="FEE_ITEMCODE")
@NamedQuery(name="FeeItemcode.findAll", query="SELECT f FROM FeeItemcode f")
public class FeeItemcode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="BILL_TYPE_CODE")
	private String billTypeCode;

	@Column(name="BILL_TYPE_NAME")
	private String billTypeName;

	@Column(name="\"TIMES\"")
	private String times;

	@Column(name="\"ENABLE\"")
	private String enable;

	@Column(name="FEE_COND")
	private String feeCond;

	@Column(name="FEE_DESCRIPTION")
	private String feeDescription;
	
	@Id
	@Column(name="FEE_ITEM")
	private String feeItem;

	@Column(name="FEE_VALUE")
	private String feeValue;

	@Column(name="FLAG_AUTO")
	private String flagAuto;

	@Column(name="FLAG_CHANGE")
	private String flagChange;

	@Column(name="FLAG_INGATE")
	private String flagIngate;

	private String remark;

	private String tax;

	private String unit;

	public FeeItemcode() {
	}

	public String getBillTypeCode() {
		return this.billTypeCode;
	}

	public void setBillTypeCode(String billTypeCode) {
		this.billTypeCode = billTypeCode;
	}

	public String getBillTypeName() {
		return this.billTypeName;
	}

	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
	}


	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getFeeCond() {
		return this.feeCond;
	}

	public void setFeeCond(String feeCond) {
		this.feeCond = feeCond;
	}

	public String getFeeDescription() {
		return this.feeDescription;
	}

	public void setFeeDescription(String feeDescription) {
		this.feeDescription = feeDescription;
	}

	public String getFeeItem() {
		return this.feeItem;
	}

	public void setFeeItem(String feeItem) {
		this.feeItem = feeItem;
	}

	public String getFeeValue() {
		return this.feeValue;
	}

	public void setFeeValue(String feeValue) {
		this.feeValue = feeValue;
	}

	public String getFlagAuto() {
		return this.flagAuto;
	}

	public void setFlagAuto(String flagAuto) {
		this.flagAuto = flagAuto;
	}

	public String getFlagChange() {
		return this.flagChange;
	}

	public void setFlagChange(String flagChange) {
		this.flagChange = flagChange;
	}

	public String getFlagIngate() {
		return this.flagIngate;
	}

	public void setFlagIngate(String flagIngate) {
		this.flagIngate = flagIngate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}