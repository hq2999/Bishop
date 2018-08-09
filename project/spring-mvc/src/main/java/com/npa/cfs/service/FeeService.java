package com.npa.cfs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;




import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npa.cfs.dao.CommonDao;
import com.npa.cfs.dto.CountFeeDto;
import com.npa.cfs.entity.CtnCodeMegathermal;
import com.npa.cfs.entity.CtnDatActCtninfo;
import com.npa.cfs.entity.CtnDatFeeAdditional;
import com.npa.cfs.entity.CtnDatFeeReceived;
import com.npa.cfs.entity.FeeItemcode;

@Service(value="feeService")
@Transactional
public class FeeService {
	
	private final static Logger logger = Logger.getLogger(FeeService.class);
	
	ScriptEngineManager manager = new ScriptEngineManager();   
	ScriptEngine engine = manager.getEngineByName("groovy");

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
    private CommonDao commonDao;
	
	/**
	 * 抽取按费率表配置策略产生出的费用
	 */
	public List<CountFeeDto> getAutoFee(CtnDatActCtninfo ctninfoPara, String enddate){
		String serialno = ctninfoPara.getSerialno();
		
		String ctnno = "";
		String ctntype = "";
		String purposecode = "";
		String cold = "";
		String indate = "";
		String ctnid = "";
		String weigh = "";
		String testGas = "";
		
		if(StringUtils.isNotBlank(serialno)){
			CtnDatActCtninfo ctninfo = hibernateTemplate.get(CtnDatActCtninfo.class, serialno);
			if(ctninfo!=null){
				ctnid = ctninfo.getSerialno();
				ctnno = ctninfo.getContainerno();
				indate = ctninfo.getInOutdateConfirm();
				purposecode = ctninfo.getInPurposecode();
				ctntype = ctninfo.getCtnsizetype();
				cold = ctninfo.getInFlagThermal();
				weigh = ctninfo.getFlagWeigh();
				testGas = ctninfo.getFlagGt();
			}

			engine.put("进箱", true);
			engine.put("提箱", true);
			
		} else {
			purposecode = ctninfoPara.getInPurposecode(); 
			ctntype = ctninfoPara.getCtnsizetype();
			
			engine.put("进箱", true);
			engine.put("提箱", false);
		}
		
		CtnCodeMegathermal ctnCodeMegathermal = hibernateTemplate.get(CtnCodeMegathermal.class , "shuhu");
		
		String t1 = ctnCodeMegathermal.getBeginDate();
		String t2 = ctnCodeMegathermal.getEndDate();
		
		if(StringUtils.isBlank(indate)){
			indate = new DateTime().toString("yyyyMMdd");
		}
		
		String[] t = getMegathermalDays(indate, enddate, t1, t2).split(":");
		
		engine.put("全部", true);
		
		engine.put("神化高温天数", Integer.parseInt(t[0]));
		engine.put("神化普通天数", Integer.parseInt(t[1]));
		engine.put("堆存天数", Integer.parseInt(t[2]));
		
		ctnCodeMegathermal = hibernateTemplate.get(CtnCodeMegathermal.class , "matou");
		t1 = ctnCodeMegathermal.getBeginDate();
		t2 = ctnCodeMegathermal.getEndDate();
		
		t = getMegathermalDays(indate, enddate, t1, t2).split(":");
		engine.put("码头高温天数", Integer.parseInt(t[0]));
		engine.put("码头普通天数", Integer.parseInt(t[1]));
		
		//进出场目的（性质）------------------------------------
		if("ZF".equals(purposecode)) {
			engine.put("暂放", true);
		} else {
			engine.put("暂放", false);
		}
		
		if("JKZXZ".equals(purposecode)) {
			engine.put("进口直卸重", true);
		} else {
			engine.put("进口直卸重", false);
		}
		
		if("JKZXK".equals(purposecode)) {
			engine.put("进口直卸空", true);
		} else {
			engine.put("进口直卸空", false);
		}
		
		if("CKZC".equals(purposecode)) {
			engine.put("出口转场", true);
		} else {
			engine.put("出口转场", false);
		}
		
		if("SG".equals(purposecode)) {
			engine.put("疏港", true);
		} else {
			engine.put("疏港", false);
		}
		//-----------------------------------------------------进出场目的（性质）
		
		//箱型------------------------------------------------------------
		if(ctntype.startsWith("4")){
			engine.put("大箱", true);
			engine.put("小箱", false);
			
		} else {
			engine.put("小箱", true);
			engine.put("大箱", false);
		}
		//-----------------------------------------------------------箱型
		
		if("Y".equals(cold)){
			engine.put("冷箱", true);
		} else {
			engine.put("冷箱", false);
		}
		
		if("Y".equals(weigh)){
			engine.put("过磅", true);
		} else {
			engine.put("过磅", false);
		}
		
		if("Y".equals(testGas)){
			engine.put("测气", true);
		} else {
			engine.put("测气", false);
		}
		
		String hql = "select t from FeeItemcode t where t.enable='Y'";
		
		if(StringUtils.isEmpty(ctnid)){
			hql += " and t.flagIngate='Y'";
		}
		
		List<FeeItemcode> feeCodeList = (List<FeeItemcode>)hibernateTemplate.find(hql);

		List<CountFeeDto> result = new ArrayList<CountFeeDto>();
		
		for(int i=0;i<feeCodeList.size();i++){
			try {
				if(feeCodeList.get(i).getFeeCond()!=null && "true".equals(engine.eval(feeCodeList.get(i).getFeeCond()).toString())){
			
					float feeVal = Float.parseFloat(engine.eval(feeCodeList.get(i).getFeeValue()).toString());
					
					String strTimes = feeCodeList.get(i).getTimes();
					int times=0;
					
					if(StringUtils.isNotBlank(strTimes)){
						times = Integer.parseInt(engine.eval(strTimes).toString());
					} else {
						times=1;
					}
					
					float receValue = 0;
					
					if(StringUtils.isEmpty(feeCodeList.get(i).getTimes())){
						receValue = feeVal;
					} else {
						receValue = feeVal * times;
					}
					
					if(receValue<0.00000001){
						continue;
					}
					
					CountFeeDto cfd = new CountFeeDto();
					cfd.setFeeName(StringUtils.trimToEmpty(feeCodeList.get(i).getFeeDescription()));
					cfd.setFeeValue(StringUtils.trimToEmpty(String.valueOf(feeVal)));
					cfd.setFeeCond(StringUtils.trimToEmpty(feeCodeList.get(i).getFeeCond()));
					cfd.setReceValue(StringUtils.trimToEmpty(String.valueOf(receValue)));
					
					if("Y".equals(feeCodeList.get(i).getFlagIngate())){
						cfd.setOptType("进箱");
					} else {
						cfd.setOptType("提箱");
					}
					
					String unit = StringUtils.trimToEmpty(feeCodeList.get(i).getUnit());
					
					cfd.setUnit(unit);
					
					if(unit.length()>0){
						cfd.setRemark(times + StringUtils.trimToEmpty(feeCodeList.get(i).getUnit()));
					} else {
						cfd.setRemark("");
					}
					
					cfd.setTimes(StringUtils.trimToEmpty(String.valueOf(times)));
					cfd.setFeeid(StringUtils.trimToEmpty(feeCodeList.get(i).getFeeItem()));
					
					result.add(cfd);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * //抽取手动添加的费用
	 */
	public List<CountFeeDto> getAdditionalFee(String ctnid){
		//取自定义费用
		String hql = "select t from CtnDatFeeAdditional t where ctnid=?";
		List<CtnDatFeeAdditional> list = (List<CtnDatFeeAdditional>)hibernateTemplate.find(hql, ctnid);
		
		List<CountFeeDto> result = new ArrayList<CountFeeDto>();
		for(int i=0;i<list.size();i++){
			CountFeeDto cfd = new CountFeeDto();
			cfd.setFeeName(StringUtils.trimToEmpty(list.get(i).getFeeName()));
			cfd.setFeeValue(StringUtils.trimToEmpty(list.get(i).getFeeValue()));
			cfd.setReceValue(StringUtils.trimToEmpty(list.get(i).getReceValue()));
			cfd.setRemark(StringUtils.trimToEmpty(list.get(i).getTimes()) + StringUtils.trimToEmpty(list.get(i).getUnit()));
			cfd.setTimes(StringUtils.trimToEmpty(list.get(i).getTimes()));
			cfd.setFeeid(StringUtils.trimToEmpty(list.get(i).getFeeId()));
			cfd.setId(StringUtils.trimToEmpty(list.get(i).getId()));
			cfd.setUnit(StringUtils.trimToEmpty(list.get(i).getUnit()));
			cfd.setOptType(StringUtils.trimToEmpty(list.get(i).getOptType()));
			result.add(cfd);
		}
		
		return result;
	}
	
	/**
	 * 抽取已收到的费用
	 */
	public List<CtnDatFeeReceived> getReceivedFee(CtnDatFeeReceived para){
		String hql = "select t from CtnDatFeeReceived t where ctnid=? or (ctnid is null and ctnno=?)";
		List<CtnDatFeeReceived> list = (List<CtnDatFeeReceived>)hibernateTemplate.find(hql, para.getCtnid(), para.getCtnno());
		return list;
	}
	
	/**
	 * 抽取杂项费用
	 */
	public List<CountFeeDto> getOtherFee(String ctnid){
		String sql="select opt_name,c,fee_value,c*fee_value sum_fee,fee_item,unit,fee_description,flag_ingate from" 
			+ " ("
			+ " select opt_name,count(*) c from "
			+ " CTN_DAT_CTNINFO_OTHER_OPT where  ctn_serialno='"+ctnid+"' group by opt_name"
			+ " ) a join fee_itemcode b on a.opt_name = b.fee_description";
		
		List<Map<String,Object>> list = commonDao.findBySql(sql, null);
		
		List<CountFeeDto> result = new ArrayList<CountFeeDto>();
		
		for(int i=0;i<list.size();i++){
			CountFeeDto cfd = new CountFeeDto();
			cfd.setFeeValue(obj2str(list.get(i).get("feeValue")));
			cfd.setFeeName(obj2str(list.get(i).get("feeDescription")));
			cfd.setReceValue(obj2str(list.get(i).get("sumFee")));
			cfd.setRemark(obj2str(list.get(i).get("c"))+ obj2str(list.get(i).get("unit")));
			cfd.setTimes(obj2str(list.get(i).get("c")));
			cfd.setFeeid(obj2str(list.get(i).get("feeItem")));
			cfd.setUnit(obj2str(list.get(i).get("unit")));		
			if("Y".equals(list.get(i).get("optType"))){
				cfd.setOptType("进箱");
			} else {
				cfd.setOptType("提箱");
			}
			
			result.add(cfd);
		}
		return result;
	}
	
	public String getMegathermalDays(String startDate , String endDate, String t1, String t2){
		int startYear = Integer.parseInt(startDate.substring(0,4));
		int startMonth = Integer.parseInt(startDate.substring(4,6));
		int startDay = Integer.parseInt(startDate.substring(6,8));

		int cz1 = new DateTime(startYear, 
				Integer.parseInt(t1.substring(0,2)), 
				Integer.parseInt(t1.substring(2,4)),0,0).getDayOfYear();
		
		int cz2 = new DateTime(startYear, 
				Integer.parseInt(t2.substring(0,2)), 
				Integer.parseInt(t2.substring(2,4)),0,0).getDayOfYear();
		
		DateTime d1 = new DateTime(startYear, startMonth, startDay,0,0);
		DateTime d2 = null;
		
		if(StringUtils.isNotBlank(endDate)){
			int endYear = Integer.parseInt(endDate.substring(0,4));
			int endMonth = Integer.parseInt(endDate.substring(4,6));
			int endDay = Integer.parseInt(endDate.substring(6,8));
			d2 = new DateTime(endYear, endMonth, endDay, 0, 0);
		} else {
			d2 = new DateTime();
		}

		int in=0;
		int out=0;
		
		int days = Days.daysBetween(d1, d2).getDays();
		
		for(int i=0;i<=days; i++){
			if (d1.getDayOfYear()>=cz1 && d1.getDayOfYear()<=cz2){
				in++;
				//System.out.println("in:" +  d1);
				
			} else {
				out++;
				//System.out.println("out:" +  d1);
			}
			
			d1 = d1.plusDays(1);

		}
		return in+":"+out+":"+(in+out);
	}
	
	private String obj2str(Object obj){
		return obj==null?"":obj.toString();
	}
	
	public String updateAdditionalFee(CtnDatFeeAdditional paraFee) throws java.lang.Exception {
		hibernateTemplate.saveOrUpdate(paraFee);
		return "ok";
	}
	
	public String delAdditionalFee(String[] ids) throws java.lang.Exception {	
		for(int i=0;i<ids.length;i++){
			jdbcTemplate.update("delete from Ctn_Dat_Fee_Additional where id=?", ids[i]);
		}
	
		return "ok";
	}
	
	public String delAdditionalFee(String feeName) throws java.lang.Exception {	
		jdbcTemplate.update("delete from Ctn_Dat_Fee_Additional where fee_name=?", feeName);
		return "ok";
	}
	
	public String updateReceivedFee(CtnDatFeeReceived paraFee) throws java.lang.Exception {
		hibernateTemplate.saveOrUpdate(paraFee);
		return "ok";
	}
	
	public String delReceivedFee(String[] ids) throws java.lang.Exception {
		for(int i=0;i<ids.length;i++){
			jdbcTemplate.update("delete from Ctn_Dat_Fee_Received where id=?", ids[i]);
		}
		return "ok";
	}
	
}
