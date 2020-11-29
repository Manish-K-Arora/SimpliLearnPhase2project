<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject Exist Already</title>
    </head>
    <body bgcolor="silver">
        <form method="post" action="subject.jsp">
            <div align = "center">
            	<h3>Wrong Input! Subject Already Exists in the list..</h3>
            	<input type="submit" value="Try Again">
            </div>
        </form>
        <form method="post" action="success.jsp">
			<div align="center">
				<h3>Or Go back to</h3>
				<input type="submit" value="Admin Dashboard">                                        
			</div>
        </form>
    </body>
</html>