<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class-Subject-Teacher-Exist</title>
    </head>
    <body bgcolor="silver">
        <form method="post" action="teacherclassSubject.jsp">
            <div align = "center">
            	<h3>Teacher with same Subject and Class already added in the list. Please check! and</h3>
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