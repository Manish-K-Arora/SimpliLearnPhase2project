<%@ page import="java.sql.*"%>
<%
    String studname = request.getParameter("studname");
	String cname = request.getParameter("cname");
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from student where Student =  '"+studname+"' and Class = '"+cname+"'");

    if (!s.isBeforeFirst()) {

    	int i = st.executeUpdate("insert into student(Student, Class) values ('" + studname + "' , '" + cname +"')");
        response.sendRedirect("studsuccess.jsp");
    	// response.sendRedirect("test.jsp");
    } else {
        response.sendRedirect("studentexist.jsp");
    }
%>