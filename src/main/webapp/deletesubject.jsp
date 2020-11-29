<%@ page import="java.sql.*"%>
<%
    String subname = request.getParameter("s");
	Class.forName("com.mysql.jdbc.Driver");
	
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
   // ResultSet s = st.executeQuery("select *from class where Class = '"+cname+"'");
    int i = st.executeUpdate("delete from subject where Subject = '" + subname + "'");
    	response.sendRedirect("subject.jsp");

%>