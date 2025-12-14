<%@ page language="java" import="entity.ProductDAO, entity.Product, java.util.*" %>
<%
    Object userObj = session.getAttribute("user");
    if (userObj == null || !"admin".equals(userObj.toString())) {
        response.sendRedirect("login.jsp");
        return;
    }

    ProductDAO dao = new ProductDAO();
    List<Product> list = dao.getAll();
%>

<!DOCTYPE html>
<html>
<head>
    <title>All Products</title>
</head>
<body>

<form action="index.jsp">
    <button type="submit"><-</button>
</form>

<h2>All Products</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Color</th>
    <th>Size</th>
    <th>Price ($)</th>
</tr>

<%
    for (Product p : list) {
%>
<tr>
    <td><%= p.getProductID() %></td>
    <td><%= p.getProductName() %></td>
    <td><%= p.getProductDescription() %></td>
    <td><%= p.getProductColor() %></td>
    <td><%= p.getProductSize() %></td>
    <td><%= p.getProductPrice() %></td>
</tr>
<%
    }
%>
</table>

</body>
</html>
