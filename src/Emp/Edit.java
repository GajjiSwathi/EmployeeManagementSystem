package Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	          PrintWriter out=response.getWriter();
		try {
			 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con;
			con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/traveltripper","root","");
		
			int id=Integer.parseInt(request.getParameter("id"));
			String NAME=request.getParameter("NAME");
			String DEPARTMENT=request.getParameter("DEPARTMENT");
			String GENDER=request.getParameter("GENDER");
			int AGE=Integer.parseInt(request.getParameter("AGE"));
			int EXPERIENCE=Integer.parseInt(request.getParameter("EXPERIENCE"));
			String specification=request.getParameter("specification");
			PreparedStatement ps=con.prepareStatement("update empjava set NAME=?,DEPARTMENT=?,GENDER=?,AGE=?,EXPERIENCE=?,specification=? where id=?");
			
			
			ps.setString(1,NAME);
			ps.setString(2,DEPARTMENT);
			ps.setString(3,GENDER);
			ps.setInt(4,AGE);
			ps.setInt(5,EXPERIENCE);
			ps.setString(6,specification);
			ps.setInt(7,id);
            ps.executeUpdate();
            out.print("updated");
            ps.close();
			con.close();
			
		}
			
		catch(Exception e) {
			System.out.println(e);
		}
		

	}
}
