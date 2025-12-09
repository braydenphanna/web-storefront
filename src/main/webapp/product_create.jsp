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

<h2>Create Product</h2>

<form action="ProductCreateServlet" method="POST">
    Product ID: <input type="number" name="id" required><br><br>
    Name: <input type="text" name="name" required><br><br>
    Description: <input type="text" name="description" required><br><br>
    Color: <input type="text" name="color" required><br><br>
    Size: <input type="text" name="size" required><br><br>
    Price: <input type="text" name="price" required><br><br>

    <button type="submit">Create Product</button>
</form>

</body>
</html>
