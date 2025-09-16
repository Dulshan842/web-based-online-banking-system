<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container text-center mt-5">
    <h2 class="mb-4">Welcome to Online Banking</h2>
    <form action="main" method="post">
        <button name="page" value="scheduled" class="btn btn-outline-primary m-2">Scheduled Transactions</button>
        <button name="page" value="create" class="btn btn-outline-success m-2">Create Transaction</button>
        <button name="page" value="paybill" class="btn btn-outline-warning m-2">Pay Bills</button>
    </form>
</div>
</body>
</html>

