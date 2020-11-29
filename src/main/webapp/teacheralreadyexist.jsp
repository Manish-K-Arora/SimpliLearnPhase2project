<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Exist Already</title>
    </head>
    <body bgcolor="silver">
        <form method="post" action="teacher.jsp">
            <div align = "center">
            	<h3>Teacher is already in the list. Please check.</h3>
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