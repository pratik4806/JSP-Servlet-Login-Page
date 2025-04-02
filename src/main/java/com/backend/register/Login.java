package com.backend.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-form")
public class Login extends HttpServlet {
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/yt_demo?useSSL=false&allowPublicKeyRetrieval=true";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "Root@12345";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			 // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM register WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
            	HttpSession session = req.getSession();
            	session.setAttribute("name_key", rs.getString("name"));
            	 RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
                 rd.include(req, resp);
            	
            }else {
            	 out.print("<h3 style='color:red;'>Email or password do not match..</h3>");
            	 // Redirect back to the login page
                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.include(req, resp);
            }
			
		}catch(Exception e) {
			e.printStackTrace();
			 out.print("<h3 style='color:red;'>"+ e.getMessage() +"</h3>");
        	 // Redirect back to the login page
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.include(req, resp);
		}
		
	}
}
