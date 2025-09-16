<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verify Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3>Verify Your Details</h3>
    <div class="card p-4 shadow-sm">
        <% String acc = request.getParameter("acc"); %>
        <% String amt = request.getParameter("amt"); %>
        <% String date = request.getParameter("date"); %>
        <% String name = request.getParameter("name"); %>
        <% String bank = request.getParameter("bank"); %>
        <% String reason = request.getParameter("reason"); %>
        <% String type = request.getParameter("type"); %>

        <% if (acc != null) { %>
            <p><strong>Account:</strong> <%= acc %></p>
            <p><strong>Amount:</strong> <%= amt %></p>
            <p><strong>Date:</strong> <%= date %></p>
            <p><strong>Name:</strong> <%= name %></p>
            <p><strong>Bank:</strong> <%= bank %></p>
            <p><strong>Reason:</strong> <%= reason %></p>
        <% } else if (type != null) { %>
            <p><strong>Bill Type:</strong> <%= type %></p>
            <p><strong>Amount:</strong> <%= amt %></p>
        <% } else { %>
            <p>No data submitted.</p>
        <% } %>

    </div>
    <form action="main" method="post" class="mt-3">
        <input type="hidden" name="page" value="confirm">
        <button class="btn btn-primary">Confirm</button>
        <a href="index.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>

