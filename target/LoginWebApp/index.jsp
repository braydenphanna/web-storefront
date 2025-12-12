<%
    Object userObj = session.getAttribute("user");
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h2>Welcome, <%= session.getAttribute("user") %>!</h2>
<p>You are now logged in.</p>

<p><a href="shoes.jsp">Go to Shoe Order Page</a><br><br>

<a href="logout">Logout</a>

<%
    if ("admin".equals(userObj.toString())) {
%>
    <h3>Admin Controls:</h3>
    <p>
        <a href="product_create.jsp">Create Product</a><br><br>
        <a href="product_read.jsp">View Products</a><br><br>
        <a href="product_update.jsp">Update Product</a><br><br>
        <a href="product_delete.jsp">Delete Product</a><br><br>
    </p>
<%
    }
%>

</body>
</html>