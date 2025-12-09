package com.example;

import entity.Product;
import entity.ProductDAO;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/ProductDeleteServlet") 
public class ProductDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        Product p = new Product();
        p.setProductID(Integer.parseInt(request.getParameter("id")));

        dao.delete(p);
        response.sendRedirect("product_read.jsp");
    }
}
