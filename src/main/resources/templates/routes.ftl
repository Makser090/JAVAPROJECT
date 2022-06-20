<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Routes</title>
</head>
<body>
<h1><div style="text-align: center">Routes Table</div></h1>

<table class="table table-dark table-striped-columns">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Distance</th>
        <th>Days in way</th>
        <th>Payment</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Delete</th>
        <th>Edit</th>

    </tr>

    <tr>
        <#list routes as routes>
        <td>${routes.id}</td>
        <td>${routes.name}</td>
        <td>${routes.distance}</td>
        <td>${routes.daysinway}</td>
        <td>${routes.payment}</td>
        <td>${routes.createdAt}</td>
        <td><#if routes.updatedAt??>
                ${routes.updatedAt}
            <#else> No update
            </#if></td>
        <td><a href="/ui/v1/routes/delete/${routes.id}">Delete</a></td>
        <td><a href="/ui/v1/routes/edit/${routes.id}">Edit</a></td>
    </tr>
    </#list>
</table>
<a href="/ui/v1/routes">
    <div style="font-size: 24px; text-align: center"><button>Create new route</button></div></a>
</body>
</html>