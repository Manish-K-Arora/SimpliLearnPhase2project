<%@ page import="java.sql.*"%>
<%
    String cname = request.getParameter("cname");
	String subname = request.getParameter("subname");
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from classsubject where Class = '"+cname+"' and Subject =  '"+subname+"'");

   	
    if (!s.isBeforeFirst()) {
    	
    	int i = st.executeUpdate("insert into classsubject(Class, Subject) values ('" + cname + "' , '" + subname + "')");
        response.sendRedirect("assignclasssuccess.jsp");
        
    } else {
        response.sendRedirect("alreadyexist.jsp");
    }
%>