<%@ page language="java" import="entity.ProductDAO, entity.Product, java.util.*" %>

<!DOCTYPE html>
<html>

<form action="shoes.jsp">
    <button type="submit"><-</button>
</form>

<head>
    <title>Shoe Order Summary</title>
</head>
<body>
<h2>Shoe Order Summary</h2>

<p>
    Product: <strong>${productName}</strong><br>
    Unit Price: $${unitPrice}<br>
    Quantity: ${quantity}<br>
</p>

<p>
    Subtotal: $${subtotal}<br>
    Discount: ${discountPercent}% (-$${discountAmount})<br>
    <strong>Total: $${total}</strong>
</p>

<p><a href="shoes.jsp">Back to order page</a></p>

</body>
</html>

