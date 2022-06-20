<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Routes</title>
</head>
<body>
<div>
    <fieldset>
        <legend> Add Route</legend>
        <form name="Route" action="" method="POST">
            Name: <@spring.formInput "form.name" "" "text"/>
            <br>
            Distance: <@spring.formInput "form.distance" "" "text"/>
            <br>
            Days in way: <@spring.formInput "form.daysinway" "" "text"/>
            <br>
            Payment: <@spring.formInput "form.payment" "" "text"/>
            <input type=submit value="Create">
        </form>
    </fieldset>
</div>
</body>
</html>