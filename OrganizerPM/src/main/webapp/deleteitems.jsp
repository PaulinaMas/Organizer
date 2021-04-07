<%-- 
    Document   : deleteitems
    Created on : 12 gru 2020, 03:13:05
    Author     : pauli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Organizer</title>
    </head>
    <body>
        <h3>${comunicat}</h3>
        <br>
        <button onclick="goBack()">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
    </body>
</html>
