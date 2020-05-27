<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<%
	Class.forName("com.mysql.jdbc.Driver");
Db con=DriverManager.getConnection("jdbc:mysql://localhost:3306/traveltripper","root","");
int k=Integer.parseInt(request.getParameter("id"));
PreparedStatement st=con.prepareStatement( "select * from empjava where id = ?");
st.setInt(1, k);
ResultSet rs = st.executeQuery();
%>
<%while(rs.next()){

%>
 
<form  action="EDIT" name="edit">
id: <%=rs.getInt(1)%><input type="hidden" name="id" value="<%=rs.getInt(1)%>"/> <br/><br/>
NAME:<input type="text" name="NAME" value="<%=rs.getString(2) %>"/><br/><br/>
DEPARTMENT:   <input type="text" name="DEPARTMENT"  value="<%=rs.getString(3) %>"/><br/><br/>
GENDER:  <input type="text" name="GENDER"  value="<%=rs.getString(4) %>"/><br/><br/>
AGE:<input type="text" name="AGE"  value="<%=rs.getInt(5) %>"/><br/><br/>
EXPERIENCE:<input type="text" name="EXPERIENCE"  value="<%=rs.getInt(6) %>"/><br/><br/>
SPECIFICATION:<input type="text"name="specification"  value="<%=rs.getString(7) %>"/><br/><br/>

<input type="submit" value="edit"/>
</form>
<%} %>
</center>
</body>
</html>