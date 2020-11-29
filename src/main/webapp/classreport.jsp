<%@ page import="java.sql.*" %>
<%ResultSet cname;%>

<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
</HEAD>

<body bgcolor="silver">
<form method = "post" action="masterreport"> 
<div align = center>

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

<center>
    <h4> Select Class Name</h1>
        <select name = "className">
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



 <input type= "submit" Value = "Generate Report">
 
 			
</div>  
</form>  
					<form method="post" action="success.jsp">
 						<div align = "center">
							<h3>Or Go back to</h3>
							<input type="submit" value="Admin Dashboard">   
						</div>   
					</form> 
</body>  
</html> 