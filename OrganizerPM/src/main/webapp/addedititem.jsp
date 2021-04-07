<%-- 
    Document   : findeditems
    Created on : 2 gru 2020, 13:58:44
    Author     : Paulina Maslowska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add event</title>
    </head>
    <body>
        <h3>${addoredit}</h3>
        <div>${added}</div>
        <br>
        <button onclick="goBack()">Go Back</button>

<script>
function goBack() {
  window.history.back();
}
</script>
    </body>
</html>
