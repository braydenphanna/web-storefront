package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String guest = request.getParameter("guest");
        HttpSession session = request.getSession();

        if ("1".equals(guest)) {
            session.setAttribute("user", "guest");
            response.sendRedirect("index.jsp");
            return;
        }

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Simple hardcoded auth - replace with DB/LDAP/etc. later
        if ("admin".equals(user) && "password".equals(pass)) {
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
