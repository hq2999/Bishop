package com.npa.cfs.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the CTN_DAT_ARC_CTNINFO database table.
 * 
 */
@Entity
@Table(name="CTN_DAT_ARC_CTNINFO")
@NamedQuery(name="CtnDatArcCtninfo.findAll", query="SELECT c FROM CtnDatArcCtninfo c")
public class CtnDatArcCtninfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ARC_DATE")
	private String arcDate;

	@Column(name="ARC_USERID")
	private String arcUserid;

	private String cfsid;

	@Column(name="CLOSE_DATE")
	private String closeDate;

	private String containerno;

	private String ctngrosswt;

	private String ctnnetwt;

	private String ctnsizetype;

	private String ctnstates;

	@Column(name="FLAG_CFS")
	private String flagCfs;

	@Column(name="FLAG_CHECK")
	private String flagCheck;

	@Column(name="FLAG_CK")
	private String flagCk;

	@Column(name="FLAG_CUSJG")
	private String flagCusjg;

	@Column(name="FLAG_DAMAGE")
	private String flagDamage;

	@Column(name="FLAG_DANGER")
	private String flagDanger;

	@Column(name="FLAG_GT")
	private String flagGt;

	@Column(name="FLAG_GUAGE")
	private String flagGuage;

	@Column(name="FLAG_IE")
	private String flagIe;

	@Column(name="FLAG_LIMITED")
	private String flagLimited;

	@Column(name="FLAG_PIER")
	private String flagPier;

	@Column(name="FLAG_SPECIAL")
	private String flagSpecial;

	@Column(name="FLAG_SX")
	private String flagSx;

	@Column(name="FLAG_THERMAL")
	private String flagThermal;

	@Column(name="FLAG_TY")
	private String flagTy;

	@Column(name="FLAG_WEIGH")
	private String flagWeigh;

	@Column(name="IN_AGENTCODE")
	private String inAgentcode;

	@Column(name="IN_BARNO")
	private String inBarno;

	@Column(name="IN_BLNO")
	private String inBlno;

	@Column(name="IN_BOOKING_NUMBER")
	private String inBookingNumber;

	@Column(name="IN_CARRIERCODE")
	private String inCarriercode;

	@Column(name="IN_CHECKMAN")
	private String inCheckman;

	@Column(name="IN_CONFIRMER")
	private String inConfirmer;

	@Column(name="IN_COSTCO_NO")
	private String inCostcoNo;

	@Column(name="IN_CTNSEALNO")
	private String inCtnsealno;

	@Column(name="IN_DATE_CHECK")
	private String inDateCheck;

	@Column(name="IN_DELI_PORT_ID")
	private String inDeliPortId;

	@Column(name="IN_DISCH_PORT_ID")
	private String inDischPortId;

	@Column(name="IN_EIRNO")
	private String inEirno;

	@Column(name="IN_FLAG_CHECK")
	private String inFlagCheck;

	@Column(name="IN_FLAG_CK")
	private String inFlagCk;

	@Column(name="IN_FLAG_CUSJG")
	private String inFlagCusjg;

	@Column(name="IN_FLAG_DAMAGE")
	private String inFlagDamage;

	@Column(name="IN_FLAG_DANGER")
	private String inFlagDanger;

	@Column(name="IN_FLAG_GUAGE")
	private String inFlagGuage;

	@Column(name="IN_FLAG_SPECIAL")
	private String inFlagSpecial;

	@Column(name="IN_FLAG_SX")
	private String inFlagSx;

	@Column(name="IN_FLAG_THERMAL")
	private String inFlagThermal;

	@Column(name="IN_FROM")
	private String inFrom;

	@Column(name="IN_INDATE_APPLY")
	private String inIndateApply;

	@Column(name="IN_INDATE_CONFIRM")
	private String inIndateConfirm;

	@Column(name="IN_INSTRUCTION_ID")
	private String inInstructionId;

	@Column(name="IN_MACHINE_DRIVER")
	private String inMachineDriver;

	@Column(name="IN_OPERATIONCODE")
	private String inOperationcode;

	@Column(name="IN_OUTDATE_APPLY")
	private String inOutdateApply;

	@Column(name="IN_OUTDATE_CONFIRM")
	private String inOutdateConfirm;

	@Column(name="IN_PURPOSECODE")
	private String inPurposecode;

	@Column(name="IN_QTZNO")
	private String inQtzno;

	@Column(name="IN_REMARK")
	private String inRemark;

	@Column(name="IN_TRANS_PORT_ID")
	private String inTransPortId;

	@Column(name="IN_TRUCK_LICENSE")
	private String inTruckLicense;

	@Column(name="IN_USERID")
	private String inUserid;

	@Column(name="IN_VESSEL_CNNAME")
	private String inVesselCnname;

	@Column(name="IN_VESSEL_ENNAME")
	private String inVesselEnname;

	@Column(name="IN_VOYAGE")
	private String inVoyage;

	private String item1;

	private String item10;

	private String item11;

	private String item12;

	private String item13;

	private String item14;

	private String item15;

	private String item16;

	private String item17;

	private String item18;

	private String item19;

	private String item2;

	private String item20;

	private String item3;

	private String item4;

	private String item5;

	private String item6;

	private String item7;

	private String item8;

	private String item9;

	private String linecode;

	private String madedate;

	@Column(name="OUT_AGENTCODE")
	private String outAgentcode;

	@Column(name="OUT_BARNO")
	private String outBarno;

	@Column(name="OUT_BLNO")
	private String outBlno;

	@Column(name="OUT_BOOKING_NUMBER")
	private String outBookingNumber;

	@Column(name="OUT_CARRIERCODE")
	private String outCarriercode;

	@Column(name="OUT_CHECKMAN")
	private String outCheckman;

	@Column(name="OUT_CONFIRMER")
	private String outConfirmer;

	@Column(name="OUT_COSTCO_NO")
	private String outCostcoNo;

	@Column(name="OUT_CTNSEALNO")
	private String outCtnsealno;

	@Column(name="OUT_DATE_CHECK")
	private String outDateCheck;

	@Column(name="OUT_DELI_PORT_ID")
	private String outDeliPortId;

	@Column(name="OUT_DISCH_PORT_ID")
	private String outDischPortId;

	@Column(name="OUT_EIRNO")
	private String outEirno;

	@Column(name="OUT_FLAG_CHECK")
	private String outFlagCheck;

	@Column(name="OUT_FLAG_CK")
	private String outFlagCk;

	@Column(name="OUT_FLAG_CUSJG")
	private String outFlagCusjg;

	@Column(name="OUT_FLAG_DAMAGE")
	private String outFlagDamage;

	@Column(name="OUT_FLAG_DANGER")
	private String outFlagDanger;

	@Column(name="OUT_FLAG_GUAGE")
	private String outFlagGuage;

	@Column(name="OUT_FLAG_SPECIAL")
	private String outFlagSpecial;

	@Column(name="OUT_FLAG_SX")
	private String outFlagSx;

	@Column(name="OUT_FLAG_THERMAL")
	private String outFlagThermal;

	@Column(name="OUT_INDATE_APPLY")
	private String outIndateApply;

	@Column(name="OUT_INDATE_CONFIRM")
	private String outIndateConfirm;

	@Column(name="OUT_INSTRUCTION_ID")
	private String outInstructionId;

	@Column(name="OUT_MACHINE_DRIVER")
	private String outMachineDriver;

	@Column(name="OUT_OPERATIONCODE")
	private String outOperationcode;

	@Column(name="OUT_OUTDATE_APPLY")
	private String outOutdateApply;

	@Column(name="OUT_OUTDATE_CONFIRM")
	private String outOutdateConfirm;

	@Column(name="OUT_PURPOSECODE")
	private String outPurposecode;

	@Column(name="OUT_QTZNO")
	private String outQtzno;

	@Column(name="OUT_REMARK")
	private String outRemark;

	@Column(name="OUT_TO")
	private String outTo;

	@Column(name="OUT_TRANS_PORT_ID")
	private String outTransPortId;

	@Column(name="OUT_TRUCK_LICENSE")
	private String outTruckLicense;

	@Column(name="OUT_USERID")
	private String outUserid;

	@Column(name="OUT_VESSEL_CNNAME")
	private String outVesselCnname;

	@Column(name="OUT_VESSEL_ENNAME")
	private String outVesselEnname;

	@Column(name="OUT_VOYAGE")
	private String outVoyage;

	private String remark;
	
	@Id
	private String serialno;

	private String yardelevation;

	private String yardid;

	private String yardlane;

	private String yardrow;

	public CtnDatArcCtninfo() {
	}

	public String getArcDate() {
		return this.arcDate;
	}

	public void setArcDate(String arcDate) {
		this.arcDate = arcDate;
	}

	public String getArcUserid() {
		return this.arcUserid;
	}

	public void setArcUserid(String arcUserid) {
		this.arcUserid = arcUserid;
	}

	public String getCfsid() {
		return this.cfsid;
	}

	public void setCfsid(String cfsid) {
		this.cfsid = cfsid;
	}

	public String getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getContainerno() {
		return this.containerno;
	}

	public void setContainerno(String containerno) {
		this.containerno = containerno;
	}

	public String getCtngrosswt() {
		return this.ctngrosswt;
	}

	public void setCtngrosswt(String ctngrosswt) {
		this.ctngrosswt = ctngrosswt;
	}

	public String getCtnnetwt() {
		return this.ctnnetwt;
	}

	public void setCtnnetwt(String ctnnetwt) {
		this.ctnnetwt = ctnnetwt;
	}

	public String getCtnsizetype() {
		return this.ctnsizetype;
	}

	public void setCtnsizetype(String ctnsizetype) {
		this.ctnsizetype = ctnsizetype;
	}

	public String getCtnstates() {
		return this.ctnstates;
	}

	public void setCtnstates(String ctnstates) {
		this.ctnstates = ctnstates;
	}

	public String getFlagCfs() {
		return this.flagCfs;
	}

	public void setFlagCfs(String flagCfs) {
		this.flagCfs = flagCfs;
	}

	public String getFlagCheck() {
		return this.flagCheck;
	}

	public void setFlagCheck(String flagCheck) {
		this.flagCheck = flagCheck;
	}

	public String getFlagCk() {
		return this.flagCk;
	}

	public void setFlagCk(String flagCk) {
		this.flagCk = flagCk;
	}

	public String getFlagCusjg() {
		return this.flagCusjg;
	}

	public void setFlagCusjg(String flagCusjg) {
		this.flagCusjg = flagCusjg;
	}

	public String getFlagDamage() {
		return this.flagDamage;
	}

	public void setFlagDamage(String flagDamage) {
		this.flagDamage = flagDamage;
	}

	public String getFlagDanger() {
		return this.flagDanger;
	}

	public void setFlagDanger(String flagDanger) {
		this.flagDanger = flagDanger;
	}

	public String getFlagGt() {
		return this.flagGt;
	}

	public void setFlagGt(String flagGt) {
		this.flagGt = flagGt;
	}

	public String getFlagGuage() {
		return this.flagGuage;
	}

	public void setFlagGuage(String flagGuage) {
		this.flagGuage = flagGuage;
	}

	public String getFlagIe() {
		return this.flagIe;
	}

	public void setFlagIe(String flagIe) {
		this.flagIe = flagIe;
	}

	public String getFlagLimited() {
		return this.flagLimited;
	}

	public void setFlagLimited(String flagLimited) {
		this.flagLimited = flagLimited;
	}

	public String getFlagPier() {
		return this.flagPier;
	}

	public void setFlagPier(String flagPier) {
		this.flagPier = flagPier;
	}

	public String getFlagSpecial() {
		return this.flagSpecial;
	}

	public void setFlagSpecial(String flagSpecial) {
		this.flagSpecial = flagSpecial;
	}

	public String getFlagSx() {
		return this.flagSx;
	}

	public void setFlagSx(String flagSx) {
		this.flagSx = flagSx;
	}

	public String getFlagThermal() {
		return this.flagThermal;
	}

	public void setFlagThermal(String flagThermal) {
		this.flagThermal = flagThermal;
	}

	public String getFlagTy() {
		return this.flagTy;
	}

	public void setFlagTy(String flagTy) {
		this.flagTy = flagTy;
	}

	public String getFlagWeigh() {
		return this.flagWeigh;
	}

	public void setFlagWeigh(String flagWeigh) {
		this.flagWeigh = flagWeigh;
	}

	public String getInAgentcode() {
		return this.inAgentcode;
	}

	public void setInAgentcode(String inAgentcode) {
		this.inAgentcode = inAgentcode;
	}

	public String getInBarno() {
		return this.inBarno;
	}

	public void setInBarno(String inBarno) {
		this.inBarno = inBarno;
	}

	public String getInBlno() {
		return this.inBlno;
	}

	public void setInBlno(String inBlno) {
		this.inBlno = inBlno;
	}

	public String getInBookingNumber() {
		return this.inBookingNumber;
	}

	public void setInBookingNumber(String inBookingNumber) {
		this.inBookingNumber = inBookingNumber;
	}

	public String getInCarriercode() {
		return this.inCarriercode;
	}

	public void setInCarriercode(String inCarriercode) {
		this.inCarriercode = inCarriercode;
	}

	public String getInCheckman() {
		return this.inCheckman;
	}

	public void setInCheckman(String inCheckman) {
		this.inCheckman = inCheckman;
	}

	public String getInConfirmer() {
		return this.inConfirmer;
	}

	public void setInConfirmer(String inConfirmer) {
		this.inConfirmer = inConfirmer;
	}

	public String getInCostcoNo() {
		return this.inCostcoNo;
	}

	public void setInCostcoNo(String inCostcoNo) {
		this.inCostcoNo = inCostcoNo;
	}

	public String getInCtnsealno() {
		return this.inCtnsealno;
	}

	public void setInCtnsealno(String inCtnsealno) {
		this.inCtnsealno = inCtnsealno;
	}

	public String getInDateCheck() {
		return this.inDateCheck;
	}

	public void setInDateCheck(String inDateCheck) {
		this.inDateCheck = inDateCheck;
	}

	public String getInDeliPortId() {
		return this.inDeliPortId;
	}

	public void setInDeliPortId(String inDeliPortId) {
		this.inDeliPortId = inDeliPortId;
	}

	public String getInDischPortId() {
		return this.inDischPortId;
	}

	public void setInDischPortId(String inDischPortId) {
		this.inDischPortId = inDischPortId;
	}

	public String getInEirno() {
		return this.inEirno;
	}

	public void setInEirno(String inEirno) {
		this.inEirno = inEirno;
	}

	public String getInFlagCheck() {
		return this.inFlagCheck;
	}

	public void setInFlagCheck(String inFlagCheck) {
		this.inFlagCheck = inFlagCheck;
	}

	public String getInFlagCk() {
		return this.inFlagCk;
	}

	public void setInFlagCk(String inFlagCk) {
		this.inFlagCk = inFlagCk;
	}

	public String getInFlagCusjg() {
		return this.inFlagCusjg;
	}

	public void setInFlagCusjg(String inFlagCusjg) {
		this.inFlagCusjg = inFlagCusjg;
	}

	public String getInFlagDamage() {
		return this.inFlagDamage;
	}

	public void setInFlagDamage(String inFlagDamage) {
		this.inFlagDamage = inFlagDamage;
	}

	public String getInFlagDanger() {
		return this.inFlagDanger;
	}

	public void setInFlagDanger(String inFlagDanger) {
		this.inFlagDanger = inFlagDanger;
	}

	public String getInFlagGuage() {
		return this.inFlagGuage;
	}

	public void setInFlagGuage(String inFlagGuage) {
		this.inFlagGuage = inFlagGuage;
	}

	public String getInFlagSpecial() {
		return this.inFlagSpecial;
	}

	public void setInFlagSpecial(String inFlagSpecial) {
		this.inFlagSpecial = inFlagSpecial;
	}

	public String getInFlagSx() {
		return this.inFlagSx;
	}

	public void setInFlagSx(String inFlagSx) {
		this.inFlagSx = inFlagSx;
	}

	public String getInFlagThermal() {
		return this.inFlagThermal;
	}

	public void setInFlagThermal(String inFlagThermal) {
		this.inFlagThermal = inFlagThermal;
	}

	public String getInFrom() {
		return this.inFrom;
	}

	public void setInFrom(String inFrom) {
		this.inFrom = inFrom;
	}

	public String getInIndateApply() {
		return this.inIndateApply;
	}

	public void setInIndateApply(String inIndateApply) {
		this.inIndateApply = inIndateApply;
	}

	public String getInIndateConfirm() {
		return this.inIndateConfirm;
	}

	public void setInIndateConfirm(String inIndateConfirm) {
		this.inIndateConfirm = inIndateConfirm;
	}

	public String getInInstructionId() {
		return this.inInstructionId;
	}

	public void setInInstructionId(String inInstructionId) {
		this.inInstructionId = inInstructionId;
	}

	public String getInMachineDriver() {
		return this.inMachineDriver;
	}

	public void setInMachineDriver(String inMachineDriver) {
		this.inMachineDriver = inMachineDriver;
	}

	public String getInOperationcode() {
		return this.inOperationcode;
	}

	public void setInOperationcode(String inOperationcode) {
		this.inOperationcode = inOperationcode;
	}

	public String getInOutdateApply() {
		return this.inOutdateApply;
	}

	public void setInOutdateApply(String inOutdateApply) {
		this.inOutdateApply = inOutdateApply;
	}

	public String getInOutdateConfirm() {
		return this.inOutdateConfirm;
	}

	public void setInOutdateConfirm(String inOutdateConfirm) {
		this.inOutdateConfirm = inOutdateConfirm;
	}

	public String getInPurposecode() {
		return this.inPurposecode;
	}

	public void setInPurposecode(String inPurposecode) {
		this.inPurposecode = inPurposecode;
	}

	public String getInQtzno() {
		return this.inQtzno;
	}

	public void setInQtzno(String inQtzno) {
		this.inQtzno = inQtzno;
	}

	public String getInRemark() {
		return this.inRemark;
	}

	public void setInRemark(String inRemark) {
		this.inRemark = inRemark;
	}

	public String getInTransPortId() {
		return this.inTransPortId;
	}

	public void setInTransPortId(String inTransPortId) {
		this.inTransPortId = inTransPortId;
	}

	public String getInTruckLicense() {
		return this.inTruckLicense;
	}

	public void setInTruckLicense(String inTruckLicense) {
		this.inTruckLicense = inTruckLicense;
	}

	public String getInUserid() {
		return this.inUserid;
	}

	public void setInUserid(String inUserid) {
		this.inUserid = inUserid;
	}

	public String getInVesselCnname() {
		return this.inVesselCnname;
	}

	public void setInVesselCnname(String inVesselCnname) {
		this.inVesselCnname = inVesselCnname;
	}

	public String getInVesselEnname() {
		return this.inVesselEnname;
	}

	public void setInVesselEnname(String inVesselEnname) {
		this.inVesselEnname = inVesselEnname;
	}

	public String getInVoyage() {
		return this.inVoyage;
	}

	public void setInVoyage(String inVoyage) {
		this.inVoyage = inVoyage;
	}

	public String getItem1() {
		return this.item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem10() {
		return this.item10;
	}

	public void setItem10(String item10) {
		this.item10 = item10;
	}

	public String getItem11() {
		return this.item11;
	}

	public void setItem11(String item11) {
		this.item11 = item11;
	}

	public String getItem12() {
		return this.item12;
	}

	public void setItem12(String item12) {
		this.item12 = item12;
	}

	public String getItem13() {
		return this.item13;
	}

	public void setItem13(String item13) {
		this.item13 = item13;
	}

	public String getItem14() {
		return this.item14;
	}

	public void setItem14(String item14) {
		this.item14 = item14;
	}

	public String getItem15() {
		return this.item15;
	}

	public void setItem15(String item15) {
		this.item15 = item15;
	}

	public String getItem16() {
		return this.item16;
	}

	public void setItem16(String item16) {
		this.item16 = item16;
	}

	public String getItem17() {
		return this.item17;
	}

	public void setItem17(String item17) {
		this.item17 = item17;
	}

	public String getItem18() {
		return this.item18;
	}

	public void setItem18(String item18) {
		this.item18 = item18;
	}

	public String getItem19() {
		return this.item19;
	}

	public void setItem19(String item19) {
		this.item19 = item19;
	}

	public String getItem2() {
		return this.item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem20() {
		return this.item20;
	}

	public void setItem20(String item20) {
		this.item20 = item20;
	}

	public String getItem3() {
		return this.item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getItem4() {
		return this.item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getItem5() {
		return this.item5;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	public String getItem6() {
		return this.item6;
	}

	public void setItem6(String item6) {
		this.item6 = item6;
	}

	public String getItem7() {
		return this.item7;
	}

	public void setItem7(String item7) {
		this.item7 = item7;
	}

	public String getItem8() {
		return this.item8;
	}

	public void setItem8(String item8) {
		this.item8 = item8;
	}

	public String getItem9() {
		return this.item9;
	}

	public void setItem9(String item9) {
		this.item9 = item9;
	}

	public String getLinecode() {
		return this.linecode;
	}

	public void setLinecode(String linecode) {
		this.linecode = linecode;
	}

	public String getMadedate() {
		return this.madedate;
	}

	public void setMadedate(String madedate) {
		this.madedate = madedate;
	}

	public String getOutAgentcode() {
		return this.outAgentcode;
	}

	public void setOutAgentcode(String outAgentcode) {
		this.outAgentcode = outAgentcode;
	}

	public String getOutBarno() {
		return this.outBarno;
	}

	public void setOutBarno(String outBarno) {
		this.outBarno = outBarno;
	}

	public String getOutBlno() {
		return this.outBlno;
	}

	public void setOutBlno(String outBlno) {
		this.outBlno = outBlno;
	}

	public String getOutBookingNumber() {
		return this.outBookingNumber;
	}

	public void setOutBookingNumber(String outBookingNumber) {
		this.outBookingNumber = outBookingNumber;
	}

	public String getOutCarriercode() {
		return this.outCarriercode;
	}

	public void setOutCarriercode(String outCarriercode) {
		this.outCarriercode = outCarriercode;
	}

	public String getOutCheckman() {
		return this.outCheckman;
	}

	public void setOutCheckman(String outCheckman) {
		this.outCheckman = outCheckman;
	}

	public String getOutConfirmer() {
		return this.outConfirmer;
	}

	public void setOutConfirmer(String outConfirmer) {
		this.outConfirmer = outConfirmer;
	}

	public String getOutCostcoNo() {
		return this.outCostcoNo;
	}

	public void setOutCostcoNo(String outCostcoNo) {
		this.outCostcoNo = outCostcoNo;
	}

	public String getOutCtnsealno() {
		return this.outCtnsealno;
	}

	public void setOutCtnsealno(String outCtnsealno) {
		this.outCtnsealno = outCtnsealno;
	}

	public String getOutDateCheck() {
		return this.outDateCheck;
	}

	public void setOutDateCheck(String outDateCheck) {
		this.outDateCheck = outDateCheck;
	}

	public String getOutDeliPortId() {
		return this.outDeliPortId;
	}

	public void setOutDeliPortId(String outDeliPortId) {
		this.outDeliPortId = outDeliPortId;
	}

	public String getOutDischPortId() {
		return this.outDischPortId;
	}

	public void setOutDischPortId(String outDischPortId) {
		this.outDischPortId = outDischPortId;
	}

	public String getOutEirno() {
		return this.outEirno;
	}

	public void setOutEirno(String outEirno) {
		this.outEirno = outEirno;
	}

	public String getOutFlagCheck() {
		return this.outFlagCheck;
	}

	public void setOutFlagCheck(String outFlagCheck) {
		this.outFlagCheck = outFlagCheck;
	}

	public String getOutFlagCk() {
		return this.outFlagCk;
	}

	public void setOutFlagCk(String outFlagCk) {
		this.outFlagCk = outFlagCk;
	}

	public String getOutFlagCusjg() {
		return this.outFlagCusjg;
	}

	public void setOutFlagCusjg(String outFlagCusjg) {
		this.outFlagCusjg = outFlagCusjg;
	}

	public String getOutFlagDamage() {
		return this.outFlagDamage;
	}

	public void setOutFlagDamage(String outFlagDamage) {
		this.outFlagDamage = outFlagDamage;
	}

	public String getOutFlagDanger() {
		return this.outFlagDanger;
	}

	public void setOutFlagDanger(String outFlagDanger) {
		this.outFlagDanger = outFlagDanger;
	}

	public String getOutFlagGuage() {
		return this.outFlagGuage;
	}

	public void setOutFlagGuage(String outFlagGuage) {
		this.outFlagGuage = outFlagGuage;
	}

	public String getOutFlagSpecial() {
		return this.outFlagSpecial;
	}

	public void setOutFlagSpecial(String outFlagSpecial) {
		this.outFlagSpecial = outFlagSpecial;
	}

	public String getOutFlagSx() {
		return this.outFlagSx;
	}

	public void setOutFlagSx(String outFlagSx) {
		this.outFlagSx = outFlagSx;
	}

	public String getOutFlagThermal() {
		return this.outFlagThermal;
	}

	public void setOutFlagThermal(String outFlagThermal) {
		this.outFlagThermal = outFlagThermal;
	}

	public String getOutIndateApply() {
		return this.outIndateApply;
	}

	public void setOutIndateApply(String outIndateApply) {
		this.outIndateApply = outIndateApply;
	}

	public String getOutIndateConfirm() {
		return this.outIndateConfirm;
	}

	public void setOutIndateConfirm(String outIndateConfirm) {
		this.outIndateConfirm = outIndateConfirm;
	}

	public String getOutInstructionId() {
		return this.outInstructionId;
	}

	public void setOutInstructionId(String outInstructionId) {
		this.outInstructionId = outInstructionId;
	}

	public String getOutMachineDriver() {
		return this.outMachineDriver;
	}

	public void setOutMachineDriver(String outMachineDriver) {
		this.outMachineDriver = outMachineDriver;
	}

	public String getOutOperationcode() {
		return this.outOperationcode;
	}

	public void setOutOperationcode(String outOperationcode) {
		this.outOperationcode = outOperationcode;
	}

	public String getOutOutdateApply() {
		return this.outOutdateApply;
	}

	public void setOutOutdateApply(String outOutdateApply) {
		this.outOutdateApply = outOutdateApply;
	}

	public String getOutOutdateConfirm() {
		return this.outOutdateConfirm;
	}

	public void setOutOutdateConfirm(String outOutdateConfirm) {
		this.outOutdateConfirm = outOutdateConfirm;
	}

	public String getOutPurposecode() {
		return this.outPurposecode;
	}

	public void setOutPurposecode(String outPurposecode) {
		this.outPurposecode = outPurposecode;
	}

	public String getOutQtzno() {
		return this.outQtzno;
	}

	public void setOutQtzno(String outQtzno) {
		this.outQtzno = outQtzno;
	}

	public String getOutRemark() {
		return this.outRemark;
	}

	public void setOutRemark(String outRemark) {
		this.outRemark = outRemark;
	}

	public String getOutTo() {
		return this.outTo;
	}

	public void setOutTo(String outTo) {
		this.outTo = outTo;
	}

	public String getOutTransPortId() {
		return this.outTransPortId;
	}

	public void setOutTransPortId(String outTransPortId) {
		this.outTransPortId = outTransPortId;
	}

	public String getOutTruckLicense() {
		return this.outTruckLicense;
	}

	public void setOutTruckLicense(String outTruckLicense) {
		this.outTruckLicense = outTruckLicense;
	}

	public String getOutUserid() {
		return this.outUserid;
	}

	public void setOutUserid(String outUserid) {
		this.outUserid = outUserid;
	}

	public String getOutVesselCnname() {
		return this.outVesselCnname;
	}

	public void setOutVesselCnname(String outVesselCnname) {
		this.outVesselCnname = outVesselCnname;
	}

	public String getOutVesselEnname() {
		return this.outVesselEnname;
	}

	public void setOutVesselEnname(String outVesselEnname) {
		this.outVesselEnname = outVesselEnname;
	}

	public String getOutVoyage() {
		return this.outVoyage;
	}

	public void setOutVoyage(String outVoyage) {
		this.outVoyage = outVoyage;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSerialno() {
		return this.serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getYardelevation() {
		return this.yardelevation;
	}

	public void setYardelevation(String yardelevation) {
		this.yardelevation = yardelevation;
	}

	public String getYardid() {
		return this.yardid;
	}

	public void setYardid(String yardid) {
		this.yardid = yardid;
	}

	public String getYardlane() {
		return this.yardlane;
	}

	public void setYardlane(String yardlane) {
		this.yardlane = yardlane;
	}

	public String getYardrow() {
		return this.yardrow;
	}

	public void setYardrow(String yardrow) {
		this.yardrow = yardrow;
	}

}