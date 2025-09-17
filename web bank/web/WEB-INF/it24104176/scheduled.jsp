<%@ page import="java.nio.file.*, java.util.*, java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scheduled Transactions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to bottom right, #2c3e50, #34495e);
            color: #ecf0f1;
            font-family: 'Segoe UI', sans-serif;
        }
        .scheduled-container {
            max-width: 900px;
            margin: 80px auto;
            padding: 40px;
            background: linear-gradient(to bottom, #000000cc, #1c1c1cdd);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }
        .greeting {
            font-size: 1.2rem;
            margin-bottom: 15px;
            color: #d6eaf8;
            text-align: center;
        }
        .table th {
            background-color: #2c3e50;
            color: #ecf0f1;
        }
        .btn-delete {
            background: linear-gradient(to right, #c0392b, #e74c3c);
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 6px;
            font-size: 0.9rem;
            transition: transform 0.2s ease;
        }
        .btn-delete:hover {
            transform: scale(1.05);
            background: linear-gradient(to right, #e74c3c, #f1948a);
        }
    </style>
</head>
<body>
<div class="scheduled-container">
    <div class="greeting">Hi! How can I help you</div>
    <h3 class="text-center">Scheduled Transactions</h3>
    <table class="table table-bordered table-hover mt-3">
        <thead>
            <tr><th>ID</th><th>Date</th><th>Amount</th><th>Action</th></tr>
        </thead>
        <tbody>
            <%
                Path path = Paths.get("C:/Users/Randy Mordred/Desktop/IT24104176/se/web-based-online-banking-system/web bank/web/scheduled.txt");
                if (Files.exists(path)) {
                    List<String> lines = Files.readAllLines(path);
                    for (String line : lines) {
                        String[] parts = line.split(",");
                        if (parts.length >= 3) {
                            String id = parts[0];
                            String date = parts[2];
                            String amt = parts[1];
            %>
            <tr>
                <td><%= id %></td>
                <td><%= date %></td>
                <td>LKR <%= amt %></td>
                <td>
                    <form action="main" method="post">
                        <input type="hidden" name="page" value="scheduled">
                        <input type="hidden" name="id" value="<%= id %>">
                        <input type="hidden" name="date" value="<%= date %>">
                        <button class="btn-delete">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                        }
                    }
                } else {
            %>
            <tr><td colspan="4">No scheduled transactions found.</td></tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
