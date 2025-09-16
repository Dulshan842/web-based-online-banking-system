<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transaction Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to bottom right, #2c3e50, #34495e);
            color: #ecf0f1;
            font-family: 'Segoe UI', sans-serif;
        }
        .success-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 40px;
            background: linear-gradient(to bottom, #000000cc, #1c1c1cdd);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
            text-align: center;
        }
        .success-container h3 {
            color: #a9cce3;
            margin-bottom: 20px;
        }
        .btn-home {
            background: linear-gradient(to right, #2980b9, #6dd5fa);
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            font-size: 1rem;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="success-container">
    <h3>✅ Transaction Completed Successfully</h3>
    <p>Your transaction has been saved and verified.</p>
    <a href="index.jsp" class="btn-home">Return to Dashboard</a>
</div>
</body>
</html>

