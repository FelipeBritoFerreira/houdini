<%--
  Created by IntelliJ IDEA.
  User: FBF0113
  Date: 21/02/2017
  Time: 14:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="dropzone/dropzone.css">
    <link rel="stylesheet" href="css/houdini.css">


    <script src="resources/jquery-1.11.3.min.js"></script>
    <script src="js/houdini.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="dropzone/dropzone.js"></script>


</head>
<body>


<div class="col-sm-8 col-sm-offset-2" style="margin-top: 5%; margin-bottom: 5%">


    <form class="dropzone">

        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="input-arquivo">Email address</label>
            <input type="file" class="form-control" id="input-arquivo" aria-describedby="emailHelp" >
            <small class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


</div>


</body>
</html>