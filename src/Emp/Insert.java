package Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {

public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		try {
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con;
			con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/traveltripper","root","");

             out.print("inserted");
		
			int id=Integer.parseInt(request.getParameter("id"));
			String NAME=request.getParameter("NAME");
			String DEPARTMENT=request.getParameter("DEPARTMENT");
			String GENDER=request.getParameter("GENDER");
			int AGE=Integer.parseInt(request.getParameter("AGE"));
			int EXPERIENCE=Integer.parseInt(request.getParameter("EXPERIENCE"));
			String specification=request.getParameter("specification");
			PreparedStatement ps=con.prepareStatement("insert into empjava(id,NAME,DEPARTMENT,GENDER,AGE,EXPERIENCE,specification)values(?,?,?,?,?,?,?)");
			
			ps.setInt(1,id);
			ps.setString(2,NAME);
			ps.setString(3,DEPARTMENT);
			ps.setString(4,GENDER);
			ps.setInt(5,AGE);
			ps.setInt(6,EXPERIENCE);
			ps.setString(7,specification);

            ps.executeUpdate();
            ps.close();
			con.close();
			
		}
			
		catch(Exception e) {
			System.out.println(e);
		}
		

	}



	}


