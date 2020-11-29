<%@ page import="java.sql.*" %>
<%ResultSet cname, subname;%>

<html>
<head>
    <title>Select element drop down box</title>
</head>

<body bgcolor="silver">
<form method = "post" action = "assignclassSubject">
<div align = center>

<%

    try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root", "");

       Statement statement = connection.createStatement() ;

       cname =statement.executeQuery("select *from class") ;
      
%>

<center>
    <h4> Select Class Name</h1>
        <select name = "cname">
        <%  while(cname.next()){ %>
			<option><%=cname.getString(2)%></option>
        <% } %>
        </select>
</center>

<%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
<%

    try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root", "");

       Statement statement = connection.createStatement();

       subname =statement.executeQuery("select *from subject");
      
%>

<center>
    <h4> Select Subject Name</h1>
        <select name ="subname">
        <%  while(subname.next()){ %>
       	<option><%=subname.getString(2)%></option>
        <% } %>
        </select>
</center>
<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

<input type= "submit" Value = "Assign">
</div>
</form>
</body>
</html>
