package com.ray.testDBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "root";
        String pass = "ab123456..";

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/customer_tracker?useSSL=false";
        String driver = "com.mysql.cj.jdbc.Driver";

        // get connection
        try {
            PrintWriter out = response.getWriter();
            System.out.println("connecting to Database: " + jdbcUrl);
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("SUCCESS!!!");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException();
        }
    }

}
