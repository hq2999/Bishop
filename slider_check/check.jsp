<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" pageEncoding="utf-8"%>

<% 
	
	String x = request.getParameter("x");
	String x1 = session.getAttribute("x").toString();
	
    if(session.getAttribute("fcount") == null){
        session.setAttribute("fcount", 0);
    }
    
	int xx = Integer.parseInt(x);
	int xx1 = Integer.parseInt(x1);
	
	if(Math.abs(xx-xx1)<=2){
		out.print("ok");
	} else {
		out.print("no");
	}
    System.out.println("check:" + x + "," + x1);
%>