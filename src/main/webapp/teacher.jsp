<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Teacher</title>
    </head>
    <body bgcolor="silver">
        <form method="post" action="addTeacher">
            <div align = "center">
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Teacher's Name</td>
                        <td><input type="text" name="tname" value="" /></td>
                    </tr>           
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    
                </tbody>
            </table>
            </div>
        </form>
            
<div align=center>
<table border=1>
<tr>
	<td>Master List of Teachers</td>
	<td>Delete</td>
</tr>
            
<%
    try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from teacher");
    
    while(s.next()){
%>		
		<tr>
			<td><%=s.getString("Teacher")%></td>
			<td><a href="deleteteacher.jsp?t=<%=s.getString("Teacher")%>">Delete</a></td>
		</tr>
    	
    <%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>            
</table>
</div>
        
    </body>
</html>