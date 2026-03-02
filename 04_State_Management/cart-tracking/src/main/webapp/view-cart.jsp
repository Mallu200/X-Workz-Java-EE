<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Shopping Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <div class="card p-4 shadow-sm">
                    <h3>Your Cart</h3>
                    <p class="text-muted">Your cart is currently empty.</p>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card p-3 bg-white border-primary shadow-sm">
                    <h5 class="text-primary">Recently Viewed</h5>
                    <hr>
                    <%
                        // Logic to read cookies manually in JSP (since JSTL is for objects)
                        Cookie[] cookies = request.getCookies();
                        String lastItem = "None";
                        if (cookies != null) {
                            for (Cookie c : cookies) {
                                if (c.getName().equals("lastViewed")) {
                                    lastItem = URLDecoder.decode(c.getValue(), "UTF-8");
                                }
                            }
                        }
                    %>
                    <p class="fw-bold text-dark">Item: <%= lastItem %></p>
                    <small class="text-muted">Stored in your browser cookies.</small>
                </div>
            </div>
        </div>
    </div>
</body>
</html>