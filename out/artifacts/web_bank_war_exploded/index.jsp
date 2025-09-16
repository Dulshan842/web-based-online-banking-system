<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to bottom right, #2c3e50, #34495e);
            color: #ecf0f1;
            font-family: 'Segoe UI', sans-serif;
        }

        .dashboard-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 40px;
            background: linear-gradient(to bottom, #000000cc, #1c1c1cdd);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }

        .dashboard-container h2 {
            margin-bottom: 30px;
            font-weight: 600;
        }

        .greeting {
            font-size: 1.2rem;
            margin-bottom: 20px;
            color: #a9cce3;
        }

        .btn-custom {
            width: 100%;
            padding: 15px;
            font-size: 1.1rem;
            margin-bottom: 15px;
            border: none;
            border-radius: 8px;
            background: linear-gradient(to right, #2980b9, #6dd5fa);
            color: white;
            transition: transform 0.2s ease;
        }

        .btn-custom:hover {
            transform: scale(1.05);
            background: linear-gradient(to right, #3498db, #85c1e9);
        }
    </style>
</head>
<body>
<div class="dashboard-container text-center">
    <div class="greeting">Hi! How can I help you</div>
    <h2>Welcome to Online Banking</h2>
    <form action="main" method="post">
        <button name="page" value="scheduled" class="btn btn-custom">Scheduled Transactions</button>
        <button name="page" value="create" class="btn btn-custom">Create Transaction</button>
        <button name="page" value="paybill" class="btn btn-custom">Pay Bills</button>
    </form>
</div>
</body>
</html>

