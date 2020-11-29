<%@ page import="java.sql.*"%>
<%
    String tname = request.getParameter("tname");
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from teacher where Teacher = '"+tname+"'");

  
    if (!s.isBeforeFirst()) {
	   	  int i = st.executeUpdate("insert into teacher(teacher) values ('" + tname + "')");
    	  response.sendRedirect("tsuccess.jsp");
        
    } else {
        response.sendRedirect("teacheralreadyexist.jsp");
    }
%>