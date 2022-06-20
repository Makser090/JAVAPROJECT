<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Drivers</title>
</head>
<body>
<div>
    <fieldset>
        <legend> Add Driver</legend>
        <form name="Driver" action="" method="POST">
            Name: <@spring.formInput "form.name" "" "text"/>
            <br>
            Surname: <@spring.formInput "form.surname" "" "text"/>
            <br>
            Experience: <@spring.formInput "form.experience" "" "text"/>
            <br>
            Created: <@spring.formInput "form.createdAt" "" "date"/>
            <br>
            <input type=submit value="Update">
        </form>
    </fieldset>
</div>
</body>
</html>