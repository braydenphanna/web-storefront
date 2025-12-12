<%@ page language="java" import="entity.ProductDAO, entity.Product, java.util.*" %>

<%
    ProductDAO dao = new ProductDAO();
    List<Product> list = dao.getAll();

    // read selection (ID)
    String selectedID = request.getParameter("productID");
    String priceText = "";
    String selectedName = "";
    String description = "";
    String color = "";
    String size = "";

   if (selectedID != null && !selectedID.isEmpty() && selectedID.matches("\\d+")) {
        int id = Integer.parseInt(selectedID);
        Optional<Product> opt = dao.get(id);
        if (opt.isPresent()) {
            Product p = opt.get();
            priceText = "$"+String.valueOf(p.getProductPrice());
            selectedName = p.getProductName();
            description = p.getProductDescription();
            color = p.getProductColor();
            size = p.getProductSize();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Shoe Order</title>
</head>
<body>

<form action="index.jsp">
    <button type="submit"><-</button>
</form>

<h2>Order Shoes</h2>

<form action="shoe-product" method="post">

    <input type="hidden" name="action" id="action" value="">

    <label for="productID">Shoe Name:</label>
    <select name="productID" id="productID"
            onchange="document.getElementById('action').value='select'; this.form.submit();">
        <option value="">Select</option>

        <% for (Product p : list) { %>
            <option value="<%= p.getProductID() %>"
                <%= (selectedID != null && selectedID.equals(String.valueOf(p.getProductID()))) ? "selected" : "" %>>
                <%= p.getProductName() %>
            </option>
        <% } %>

    </select><br><br>

    <label>Unit Price:</label>
    <span><%= priceText.isEmpty() ? "" : priceText %></span><br><br>

    <input type="hidden" name="unitPrice" value="<%= priceText %>">
    <input type="hidden" name="productName" value="<%= selectedName %>">
    <input type="hidden" name="description" value="<%= description %>">
    <input type="hidden" name="color" value="<%= color %>">
    <input type="hidden" name="size" value="<%= size %>">

    <label>Description:</label>
    <span><%= description.isEmpty() ? "" : description %></span><br><br>

    <label>Color:</label>
    <span><%= color.isEmpty() ? "" : color %></span><br><br>

    <label>Size:</label>
    <span><%= size.isEmpty() ? "" : size %></span><br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" min="1" value="1" required><br><br>

    <button type="submit"
    <%
        boolean productSelected = !priceText.isEmpty() && !"Select a product".equals(priceText);
        if (!productSelected) {
    %>
        onclick="return false;" style="cursor: not-allowed;"
    <%
        } else {
    %>
        onclick="document.getElementById('action').value='calculate';"
    <%
        }
    %>
    >Calculate Total</button>

</form>

</body>
</html>
