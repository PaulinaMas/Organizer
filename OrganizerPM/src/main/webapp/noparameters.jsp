<%-- 
    Document   : noparameters
    Created on : 4 gru 2020, 14:05:21
    Author     : Paulina Maslowska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exception</title>
    </head>
    <body>
        <h1>Exception</h1>
        <br><div>${noparameters} </div>
                <br>
        <button onclick="goBack()">Go Back</button>

<script>
function goBack() {
  window.history.back();
}
</script>
    </body>
</html>
