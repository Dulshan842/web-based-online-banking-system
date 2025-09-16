<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scheduled Transactions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3>Scheduled Transactions</h3>
    <table class="table table-bordered table-hover mt-3">
        <thead class="table-dark">
            <tr><th>ID</th><th>Date</th><th>Amount</th><th>Action</th></tr>
        </thead>
        <tbody>
            <%-- Example row, replace with dynamic data --%>
            <tr>
                <td>TXN001</td>
                <td>2025-09-20</td>
                <td>$500</td>
                <td>
                    <form action="main" method="post">
                        <input type="hidden" name="page" value="scheduled">
                        <input type="hidden" name="id" value="TXN001">
                        <input type="hidden" name="date" value="2025-09-20">
                        <button class="btn btn-sm btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>

