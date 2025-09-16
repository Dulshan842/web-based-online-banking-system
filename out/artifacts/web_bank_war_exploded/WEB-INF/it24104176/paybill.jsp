<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pay Bills</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3>Pay Your Bills</h3>
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
            <button class="btn btn-warning">Proceed to Verification</button>
        </div>
    </form>
</div>
</body>
</html>

