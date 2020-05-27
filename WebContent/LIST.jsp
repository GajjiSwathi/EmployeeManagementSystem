<html>
<body>
<%@page import="java.sql.DriverManager" %>
<%@page import ="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@ page import="java.sql.*" %>
<%
	try{

	Db con=null;
	Statement st=null;
	ResultSet rs=null;
	String q="select * from empjava";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/traveltripper","root","");
	st=con.createStatement();
	rs=st.executeQuery(q);
%>
<table border="1">
<tr>
<td>id</td>
<td>NAME</td>
<td>DEPARTMENT</td>
<td>GENDER</td>
<td>AGE</td>
<td>EXPERIENCE</td>
<td>specification</td>
<td>ADD</td>
<td>DELETE</td>
<td>UPDATE</td>
</tr>
<%while(rs.next())
	{
	%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getInt(5) %></td>
<td><%=rs.getInt(6) %></td>
<td><%=rs.getString(7) %></td>
<td><form action="ADD.jsp">
<input type="submit" name="login" value="ADD"/>
</form></td>
<td><form action="DELETE.jsp">
<input type="submit" name="login" value="DELETE"/>
</form></td>
<td><form action="Editmodify.jsp">
<input type="submit" name="login" value="UPDATE"/>
</form></td></tr>

<%}
con.close();
}
catch(Exception e)
{
	e.printStackTrace();
	
}%>
</table>
</body>
</html>

