package com.npa.cfs.spring.controller;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.npa.cfs.dto.CountFeeDto;
import com.npa.cfs.entity.CtnDatActCtninfo;
import com.npa.cfs.entity.CtnDatFeeAdditional;
import com.npa.cfs.entity.CtnDatFeeReceived;
import com.npa.cfs.entity.CtnDatFeeRefund;
import com.npa.cfs.service.FeeService;


@Controller
@RequestMapping(value="/fee", produces = "application/json; charset=utf-8")
@ResponseBody
@Transactional
public class FeeController {
	
	ScriptEngineManager manager = new ScriptEngineManager();   
	ScriptEngine engine = manager.getEngineByName("groovy");
	
	@Autowired
    private HibernateTemplate hibernateTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	FeeService feeService;
	
	@RequestMapping(value="/allFee")
	public String allFee(CtnDatActCtninfo ctninfo, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String endDate = req.getParameter("endDate");
		List<CountFeeDto> autoFee = feeService.getAutoFee(ctninfo, endDate);
		List<CountFeeDto> additionalFee = feeService.getAdditionalFee(ctninfo.getSerialno());
		List<CountFeeDto> otherFee = feeService.getOtherFee(ctninfo.getSerialno());
		autoFee.addAll(additionalFee);
		autoFee.addAll(otherFee);
		return JSON.toJSONString(autoFee, SerializerFeature.WriteNullStringAsEmpty);
	}
	
	@RequestMapping(value="/autoFee")
	public String autoFee(CtnDatActCtninfo ctninfo, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String endDate = req.getParameter("endDate");
		return JSON.toJSONString(feeService.getAutoFee(ctninfo, endDate));
	}
	
	@RequestMapping(value="/receivedFee")
	public String receivedFee(CtnDatFeeReceived paraReceived, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		return JSON.toJSONString(feeService.getReceivedFee(paraReceived), SerializerFeature.WriteNullStringAsEmpty);
	}
	
	@RequestMapping(value="/additionalFee")
	public String additionalFee(CtnDatFeeAdditional paraAdditional, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		return JSON.toJSONString(feeService.getAdditionalFee(paraAdditional.getCtnid()));
	}
	
	@RequestMapping(value="/otherFee")
	public String otherFee(CtnDatFeeAdditional paraAdditional, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		return JSON.toJSONString(feeService.getOtherFee(paraAdditional.getCtnid()));
	}
	
	@RequestMapping(value="/updateAdditionalFee")
	public String updateAdditionalFee(CtnDatFeeAdditional paraFee, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		feeService.updateAdditionalFee(paraFee);
		return "ok";
	}
	
	@RequestMapping(value="/delAdditionalFee")
	public String delAdditionalFee(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String ids = req.getParameter("id");
		String feeName = req.getParameter("feeName");
		
		if(StringUtils.isNotBlank(ids)){
			feeService.delAdditionalFee(ids.split(","));
		}
		
		if(StringUtils.isNotBlank(feeName)){
			feeService.delAdditionalFee(feeName);
		}
		
		return "ok";
	}
	
	@RequestMapping(value="/updateReceivedFee")
	public String addReceivedFee(CtnDatFeeReceived paraFee, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		feeService.updateReceivedFee(paraFee);
		return "ok";
	}
	
	@RequestMapping(value="/delReceivedFee")
	public String delReceivedFee(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String ids = req.getParameter("id");
		if(StringUtils.isNotBlank(ids)){
			feeService.delReceivedFee(ids.split(","));
		}
		return "ok";
	}
	
	@RequestMapping(value="/findRefund")
	public String findRefund(CtnDatFeeRefund para, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		List<CtnDatFeeRefund> list = (List<CtnDatFeeRefund>)hibernateTemplate.find("select t from CtnDatFeeRefund t where t.ctnid=?", para.getCtnid());
		return JSON.toJSONString(list, SerializerFeature.WriteNullStringAsEmpty);
	}
	
	@RequestMapping(value="/deleteRefund")
	public String findRefund( HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String id = req.getParameter("id");
		
		if(StringUtils.isNotBlank(id)){
			String ids[] = id.split(",");
			for(int i=0;i<ids.length;i++){
				CtnDatFeeRefund refund = hibernateTemplate.get(CtnDatFeeRefund.class, ids[i]);
				hibernateTemplate.delete(refund);
			}
		}
		return "ok";
	}
	
	@RequestMapping(value="/rece2refund")
	public String refund(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String id = req.getParameter("id");
		String userid = req.getParameter("userid");
		
		if(StringUtils.isNotBlank(id)){
			String ids[] = id.split(",");
			for(int i=0;i<ids.length;i++){
				CtnDatFeeReceived received = hibernateTemplate.get(CtnDatFeeReceived.class, ids[i]);
				CtnDatFeeRefund refund = new CtnDatFeeRefund();
				BeanUtils.copyProperties(received, refund);
				refund.setOptUser(userid);
				refund.setOptDate(DateTime.now().toString("yyyyMMddHHmmss"));
				hibernateTemplate.merge(refund);
			}
			feeService.delReceivedFee(ids);
		}
		return "ok";
	}
	
	@RequestMapping(value="/refund2rece")
	public String deleteRefund(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws java.lang.Exception {
		String id = req.getParameter("id");
		String userid = req.getParameter("userid");
		
		if(StringUtils.isNotBlank(id)){
			String ids[] = id.split(",");
			for(int i=0;i<ids.length;i++){
				CtnDatFeeRefund refund = hibernateTemplate.get(CtnDatFeeRefund.class, ids[i]);
				CtnDatFeeReceived received = new CtnDatFeeReceived();
				BeanUtils.copyProperties(refund, received);
				refund.setOptUser(userid);
				refund.setOptDate(DateTime.now().toString("yyyyMMddHHmmss"));
				hibernateTemplate.merge(received);
				hibernateTemplate.delete(refund);
			}
		}
		return "ok";
	}
	
	
}

