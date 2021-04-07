<%-- 
    Document   : mainpage
    Created on : 4 gru 2020, 14:28:34
    Author     : Paulina Maslowska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Organizer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
       
         <h1>Organizer</h1>
         <h2>Owner: ${owner}</h2>
         <br><h3>Add event:</h3>
         <br><div>name, time and note can be empty</div>
         <br><div>When you want to delete event you have to use event's id, it can be find after Show events option</div>
         <br><div>Id is used only for edit event, when it's filled when adding event this field will be ignored.</div>
        <form action="AddEvent" method="POST">
            <p>Id:<input type=text size=20 name=editid></p>
            <p>Name:<input type=text size=20 name=addname></p>
            <p>Date:<input type=text size=20 name=adddate></p>
            <p>Time:<input type=text size=20 name=addtime></p>
            <p>Note:<input type=text size=20 name=addnote></p>
            
            <div>Choose priority</div>
            <input type="radio" id="low" name="priority" value="LOW">
    <label for="low">LOW</label><br>
    <input type="radio" id="medium" name="priority" value="MEDIUM" checked="checked">
    <label for="medium">MEDIUM</label><br>
    <input type="radio" id="high" name="priority" value="HIGH">
    <label for="high">HIGH</label><br>
    <input type="submit" value="Add event" />
    <input type="submit" formaction="EditEvent" value="Edit event" />
        </form>
          
          <br><br><h3>Find event:</h3>
        <form action="SearchEvent" method="POST">
            <p>Name:<input type=text size=20 name=findname></p>
    <input type="submit" value="Find event" />
        </form>
          
            <br><br><h3>Show all events:</h3>
             <form action="ShowEvents" method="POST">
            <input type="submit" value="Show events" />
            </form>
               <br><br><h3>Delete event:</h3>
        <form action="DeleteEvent" method="POST">
            <p>Id:<input type=text size=20 name=deleteid></p>
    <input type="submit" value="Delete event" />
        </form>
        
    </body>
</html>

