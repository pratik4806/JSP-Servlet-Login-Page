package com.backend.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration-form")
public class Register extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/yt_demo?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Root@12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String city = req.getParameter("city");
        String gender = req.getParameter("gender");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement ps = conn.prepareStatement("INSERT INTO register (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)")) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, gender);
                ps.setString(5, city);

                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    out.print("<h3 style='color:green;'>User registered successfully!</h3>");
                } else {
                    out.print("<h3 style='color:red;'>User registration failed. Try again.</h3>");
                }
            }

        } catch (ClassNotFoundException e) {
            out.print("<h3 style='color:red;'>Database driver not found!</h3>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.print("<h3 style='color:red;'>Database error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }

        // Redirect back to the form page
        RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
        rd.include(req, resp);
    }
}
