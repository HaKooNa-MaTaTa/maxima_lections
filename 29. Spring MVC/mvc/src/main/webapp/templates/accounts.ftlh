<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Accounts</title>
</head>
<body>
<h1>Accounts:</h1>
<table>
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
    </tr>
    <#list accounts as account>
        <tr>
            <th>${account.firstName}</th>
            <th>${account.lastName}</th>
            <th>${account.email}</th>
        </tr>
    </#list>
</table>
</body>
</html>