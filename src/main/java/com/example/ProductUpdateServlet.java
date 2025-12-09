package com.example;

import entity.Product;
import entity.ProductDAO;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/ProductUpdateServlet") 
public class ProductUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        Product p = new Product();
        p.setProductID(Integer.parseInt(request.getParameter("id")));
        p.setProductName(request.getParameter("name"));
        p.setProductDescription(request.getParameter("description"));
        p.setProductColor(request.getParameter("color"));
        p.setProductSize(request.getParameter("size"));
        p.setProductPrice(request.getParameter("price"));

        dao.update(p);
        response.sendRedirect("product_read.jsp");
    }
}
