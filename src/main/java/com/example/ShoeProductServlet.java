package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ShoeProductServlet", value = "/shoe-product")
public class ShoeProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

            String action = request.getParameter("action");

            String productName = request.getParameter("productName");
            String productID = request.getParameter("productID");
            String unitPriceStr = request.getParameter("unitPrice");
            String quantityStr = request.getParameter("quantity");

            // When user selects a shoe (no quantity yet): reload shoes.jsp
            if ("select".equals(action)) {
                request.getRequestDispatcher("/shoes.jsp")
                        .forward(request, response);
                return;
            }

            // When Calculate button is clicked
            if ("calculate".equals(action)) {

                if (productName == null || productName.isEmpty()
                        || unitPriceStr == null || unitPriceStr.isEmpty()
                        || quantityStr == null || quantityStr.isEmpty()) {

                    // missing values → go back to form
                    request.getRequestDispatcher("/shoeorder.jsp")
                            .forward(request, response);
                    return;
                }

                double unitPrice = Double.parseDouble(unitPriceStr);
                int quantity = Integer.parseInt(quantityStr);

                double subtotal = unitPrice * quantity;
                double discountPercent = 0.0;

                if (quantity >= 10) discountPercent = 10.0;
                else if (quantity >= 5) discountPercent = 5.0;

                double discountAmount = subtotal * (discountPercent / 100.0);
                double total = subtotal - discountAmount;

                request.setAttribute("productID", productID);
                request.setAttribute("productName", productName);
                request.setAttribute("unitPrice", unitPrice);
                request.setAttribute("quantity", quantity);
                request.setAttribute("discountPercent", discountPercent);
                request.setAttribute("discountAmount", discountAmount);
                request.setAttribute("subtotal", subtotal);
                request.setAttribute("total", total);

                request.getRequestDispatcher("/shoeResult.jsp")
                        .forward(request, response);
            }
        }
}
