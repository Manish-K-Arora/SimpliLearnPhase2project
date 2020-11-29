<%@ page import="java.sql.*"%>
<%
    String subname = request.getParameter("subname");
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from subject where Subject = '"+subname+"'");

    
    if (!s.isBeforeFirst()) {
    	int i = st.executeUpdate("insert into subject(Subject) values ('" + subname + "')");
        response.sendRedirect("subsuccess.jsp");
        
    } else {
        response.sendRedirect("subjectalreadyexist.jsp");
    }
%>