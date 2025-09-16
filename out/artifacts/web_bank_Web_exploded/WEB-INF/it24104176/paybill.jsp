<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pay Bills</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to bottom right, #2c3e50, #34495e);
            color: #ecf0f1;
            font-family: 'Segoe UI', sans-serif;
        }

        .bill-container {
            max-width: 700px;
            margin: 80px auto;
            padding: 40px;
            background: linear-gradient(to bottom, #000000cc, #1c1c1cdd);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }

        .bill-container h3 {
            margin-bottom: 30px;
            font-weight: 600;
            color: #a9cce3;
        }

        .greeting {
            font-size: 1.2rem;
            margin-bottom: 15px;
            color: #d6eaf8;
        }

        .form-label {
            color: #ecf0f1;
        }

        .form-control, .form-select {
            background-color: #f8f9fa;
            border: 1px solid #ced4da;
        }

        .btn-custom {
            width: 100%;
            padding: 15px;
            font-size: 1.1rem;
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
<div class="bill-container">
    <div class="text-center greeting">Hi! How can I help you</div>
    <h3 class="text-center">Pay Your Bills</h3>
    <form action="main" method="post" class="row g-3">
        <input type="hidden" name="page" value="verify">
        <div class="col-md-6">
            <label class="form-label">Bill Type</label>
            <select name="type" class="form-select" required>
                <option value="">Select</option>
                <option value="Electricity">Electricity</option>
                <option value="Water">Water</option>
                <option value="Internet">Internet</option>
                <option value="Phone">Phone</option>
            </select>
        </div>
        <div class="col-md-6">
            <label class="form-label">Amount</label>
            <input type="number" name="amt" class="form-control" required>
        </div>
        <div class="col-12">
            <button class="btn btn-custom">Proceed to Verification</button>
        </div>
    </form>
</div>
</body>
</html>


