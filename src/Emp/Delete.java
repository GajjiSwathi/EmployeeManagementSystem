package Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;



public class Delete extends HttpServlet {

	
		public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			try {
				int id=Integer.parseInt(request.getParameter("id"));
				PrintWriter out=response.getWriter();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con;
				
				con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/traveltripper","root","");
			
				PreparedStatement stmt=con.prepareStatement("delete from empjava where id=?");  
			out.print("deleted");
			 
				 
				stmt.setInt(1,id);
				stmt.executeUpdate(); 
				stmt.close();
				con.close();
			}
          catch(Exception e) {
	                    System.out.println(e);
                           }
	
			}
}

