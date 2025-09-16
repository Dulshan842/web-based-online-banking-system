<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verify Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to bottom right, #2c3e50, #34495e);
            color: #ecf0f1;
            font-family: 'Segoe UI', sans-serif;
        }

        .verify-container {
            max-width: 700px;
            margin: 80px auto;
            padding: 40px;
            background: linear-gradient(to bottom, #000000cc, #1c1c1cdd);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }

        .verify-container h3 {
            margin-bottom: 30px;
            font-weight: 600;
            color: #a9cce3;
            text-align: center;
        }

        .greeting {
            font-size: 1.2rem;
            margin-bottom: 15px;
            color: #d6eaf8;
            text-align: center;
        }

        .card-custom {
            background-color: #f8f9fa;
            color: #2c3e50;
            border-radius: 10px;
            padding: 25px;
            box-shadow: 0 0 10px rgba(0,0,0,0.3);
        }

        .btn-confirm {
            background: linear-gradient(to right, #2980b9, #6dd5fa);
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            font-size: 1rem;
            transition: transform 0.2s ease;
        }

        .btn-confirm:hover {
            transform: scale(1.05);
            background: linear-gradient(to right, #3498db, #85c1e9);
        }

        .btn-cancel {
            background-color: #7f8c8d;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            font-size: 1rem;
            margin-left: 10px;
        }

        .btn-cancel:hover {
            background-color: #95a5a6;
        }
    </style>
</head>
<body>
<div class="verify-container">
    <div class="greeting">Hi! How can I help you</div>
    <h3>Verify Your Details</h3>
    <div class="card-custom">
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
    <form action="main" method="post" class="mt-4 text-center">
        <input type="hidden" name="page" value="confirm">
        <button class="btn-confirm">Confirm</button>
        <a href="index.jsp" class="btn-cancel">Cancel</a>
    </form>
</div>
</body>
</html>
