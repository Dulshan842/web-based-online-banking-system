<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3>Create New Transaction</h3>
    <form action="main" method="post" class="row g-3">
        <input type="hidden" name="page" value="verify">
        <div class="col-md-6">
            <label class="form-label">Account Number</label>
            <input type="text" name="acc" class="form-control" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Amount</label>
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
            <button class="btn btn-success">Proceed to Verification</button>
        </div>
    </form>
</div>
</body>
</html>

