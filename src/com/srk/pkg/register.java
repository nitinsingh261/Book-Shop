package com.srk.pkg;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = {"/register"})

public class register  extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");      
		PrintWriter pw=res.getWriter();
		RequestDispatcher rd = null;

	String usrid =req.getParameter("uid");
	String pwd= req.getParameter("pwd");
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	final String DB_URL="jdbc:mysql://localhost/userlogin";
	final String USER = "root";
	final String PASS = "root"
			+ "";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		res.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DB_URL, USER, PASS);
		
			 PreparedStatement ps=con.prepareStatement
	                 ("insert into reg values(?,?)");

	       ps.setString(1, usrid);
	       ps.setString(2, pwd);
	       int i=ps.executeUpdate();
	       
	       if(i>0)
	       {
	         pw.println("You are sucessfully registered");
	         rd = req.getRequestDispatcher("/pageTwo.jsp");
			rd.forward(req, res);
	       }
		}
		catch(Exception e){e.printStackTrace();}

			
	} 
}