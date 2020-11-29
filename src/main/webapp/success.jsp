<%
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "")) {
%>

<body bgcolor="silver">

<div align = "center">
<h1>"Welcome to the Admin Dashboard"</h1></h1><br/>
<table border="0" width="30%" cellpadding="3">

<thead>
	<tr>
    	<th colspan="2"><h2>List Of Tasks</h2></th>
    </tr>
 </thead>
	<tbody>
    	<tr>
        	<td>
            <form action="subject.jsp">
    			<input type="submit" value="Set up Master List of all Subjects">
			</form>
            </td>
        </tr>
        <tr>
        	<td>
            <form action="teacher.jsp">
    			<input type="submit" value="Set up Master List of all Teachers">
			</form> 
			</td>
		</tr>
        <tr>
        	<td>
            <form action="class.jsp">
    			<input type="submit" value="Set up Master List of all Classes">
			</form>
			</td>
		</tr>
		<tr>
			<td>
			<form action="ClassSubject.jsp">
    			<input type="submit" value="Assign Classes for Subjects">
			</form>
			</td>
        </tr>
        <tr>
			<td>
			<form action="teacherclassSubject.jsp">
    			<input type="submit" value="Assign teachers to a class for a subject">
			</form>
			</td>
        </tr>
		<tr>
        	<td>
			<form action="student.jsp">
    			<input type="submit" value="Add Student and Assign class">
			</form>
			</td>
		</tr>
        <tr>
			<td>
			<form method="post" action="chooseclass.jsp">
    			<input type="submit" value="Get a Master List of Students">
			</form>
			</td>
		</tr>
		 <tr>
			<td>
			<form method = "post" action="classreport.jsp">
    			<input type="submit" value="View Class Report">
			</form>
			</td>
        </tr>
        <tr>
        	<form action="logout.jsp">  
            	<td><input type="submit" value="Logout" align=center></td>
		</tr>
	</tbody>
	
</table>
</div>

<%} 
  else 
  		{
%>
		<%=session.getAttribute("userid")%>

		<a href='logout.jsp'>Log out</a>
		<%
    	}
%>
