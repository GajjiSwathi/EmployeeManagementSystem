
<%@ page language="java" errorPage="checkid.jsp" %>
<%@ page import="java.lang.*"%>
<% 
String a=request.getParameter("NAME");
String b=request.getParameter("PASSWORD");

if(a.equals("swathi")&& b.equals("welcome"))
     {
        response.sendRedirect("Three.jsp");
      }
else{
	
	throw new RuntimeException("SORRY!!!ENTER THE CORRECT NAME AND PASSWORD");
    }
%>

