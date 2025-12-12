<%@ page language="java" import="entity.ProductDAO, entity.Product, java.util.*" %>
<%
    Object userObj = session.getAttribute("user");
    if (userObj == null || !"admin".equals(userObj.toString())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<body>

<form action="index.jsp">
    <button type="submit"><-</button>
</form>

<h2>Delete Product</h2>

<form action="ProductDeleteServlet" method="POST">
    Product ID: <input type="number" name="id" required><br><br>
    <button type="submit">Delete</button>
</form>

</body>
</html>
