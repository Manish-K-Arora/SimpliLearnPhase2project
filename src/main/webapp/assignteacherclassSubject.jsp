<%@ page import="java.sql.*"%>
<%
    String cname = request.getParameter("cname");
	String subname = request.getParameter("subname");
	String tname = request.getParameter("tname");
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from tcs where Class = '"+cname+"' and Subject =  '"+subname+"' and Teacher = '"+tname+"'");
   	
    if (!s.isBeforeFirst()) {
    	int i = st.executeUpdate("insert into tcs(Class , Subject, Teacher) values ('" + cname + "' , '" + subname + "' , '" + tname + "')");
    	response.sendRedirect("tcssuccess.jsp");
        
    } else {
        response.sendRedirect("tcsexist.jsp");
    }
%>