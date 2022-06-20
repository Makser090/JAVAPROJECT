<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Drivers</title>
</head>
<body>
<h1><div style="text-align: center">Drivers Table</div></h1>

<table class="table table-info table-striped-columns table-bordered border-dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Experience</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Delete</th>
        <th>Edit</th>

    </tr>

    <tr>
        <#list drivers as driver>
        <td>${driver.id}</td>
        <td>${driver.name}</td>
        <td>${driver.surname}</td>
        <td>${driver.experience}</td>
        <td>${driver.createdAt}</td>
        <td><#if driver.updatedAt??>
                ${driver.updatedAt}
            <#else> No update
            </#if></td>
        <td><a href="/ui/v1/drivers/delete/${driver.id}">Delete</a></td>
        <td><a href="/ui/v1/drivers/edit/${driver.id}">Edit</a></td>
    </tr>
    </#list>
</table>
<a href="/ui/v1/drivers">
<div style="font-size: 24px; text-align: center"><button>Create new driver</button></div></a>
</body>
</html>