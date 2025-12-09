package com.example;

import entity.Product;
import entity.ProductDAO;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/ProductCreateServlet") 
public class ProductCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        Product p = new Product(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("color"),
                request.getParameter("size"),
                request.getParameter("price")
        );

        dao.insert(p);
        response.sendRedirect("product_read.jsp");
    }
}
