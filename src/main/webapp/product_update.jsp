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

<h2>Update Product</h2>

<form action="ProductUpdateServlet" method="POST">
    Product ID (to update): <input type="number" name="id" required><br><br>
    New Name: <input type="text" name="name"><br><br>
    New Description: <input type="text" name="description"><br><br>
    New Color: <input type="text" name="color"><br><br>
    New Size: <input type="text" name="size"><br><br>
    New Price: <input type="text" name="price"><br><br>

    <button type="submit">Update Product</button>
</form>

</body>
</html>
