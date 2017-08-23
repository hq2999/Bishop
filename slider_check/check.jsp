<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" pageEncoding="utf-8"%>

<% 
	
	String x = request.getParameter("x");
	String x1 = session.getAttribute("x").toString();
	
	int xx = Integer.parseInt(x);
	int xx1 = Integer.parseInt(x1);
	
	if(xx==xx1){
		out.print("ok");
	} else {
		out.print("no");
	}
    System.out.println("check:" + x + "," + x1);
%>