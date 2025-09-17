<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to bottom right, #2c3e50, #34495e);
            color: #ecf0f1;
            font-family: 'Segoe UI', sans-serif;
        }

        .transaction-container {
            max-width: 800px;
            margin: 80px auto;
            padding: 40px;
            background: linear-gradient(to bottom, #000000cc, #1c1c1cdd);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }

        .transaction-container h3 {
            margin-bottom: 30px;
            font-weight: 600;
            color: #a9cce3;
        }

        .greeting {
            font-size: 1.2rem;
            margin-bottom: 15px;
            color: #d6eaf8;
            text-align: center;
        }

        .form-label {
            color: #ecf0f1;
        }

        .form-control {
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
<div class="transaction-container">
    <div class="greeting">Hi! How can I help you</div>
    <h3 class="text-center">Create New Transaction</h3>
    <form action="main" method="post" class="row g-3">
        <input type="hidden" name="page" value="verify">
        <div class="col-md-6">
            <label class="form-label">Account Number</label>
            <input type="text" name="acc" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Amount in LKR</label>
            <input type="number" name="amt" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Date</label>
            <input type="date" name="date" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Beneficiary Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Beneficiary Bank</label>
            <input type="text" name="bank" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Reason</label>
            <input type="text" name="reason" class="form-control" required>
        </div>
        <div class="col-12">
            <button class="btn btn-custom">Proceed to Verification</button>
        </div>
    </form>
</div>
</body>
</html>


