<%@ page import="java.sql.*" %>
<%ResultSet cname, subname;%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body bgcolor="silver">
        <form method="post" action="addStudent">
            <div align = "center">
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Student Details</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Student Name</td>
                        <td><input type="text" name="studname" value="" /></td>
                    </tr>           
                     <tr>
<%

    try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/mysql",
                    "root", "");

       Statement statement = connection.createStatement() ;

       cname =statement.executeQuery("select *from class") ;
      
%>
                        <td>Class Assigned</td>
                        <td><select name = "cname">
        					<%  while(cname.next()){ %>
							<option><%=cname.getString(2)%></option>
      						  <% } %>
       						 </select></td>
       						 <%
        						}
       							 catch(Exception e)
        						{
             						out.println("wrong entry"+e);
        						}
							%>
                    </tr> 
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    
                </tbody>
            </table>
            </div>
        </form>
    </body>
</html>