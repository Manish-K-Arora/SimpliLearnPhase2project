<%@ page import="java.sql.*"%>
<%
    String cname = request.getParameter("cname");
	Class.forName("com.mysql.jdbc.Driver");
	
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
            "root", "");
    Statement st = con.createStatement();
    ResultSet s = st.executeQuery("select *from class where Class = '"+cname+"'");
    
    if(!s.isBeforeFirst())
    {
    	//response.sendRedirect("success.jsp");
    	int i = st.executeUpdate("insert into class(Class) values ('" + cname + "')");
    	response.sendRedirect("csuccess.jsp");
    }
 //   int i = st.executeUpdate("insert into class(Class) values ('" + cname + "')");
//    if (i > 0) {
        
  //  	response.sendRedirect("csuccess.jsp");
        
        
//    } 
else {
	//int i = st.executeUpdate("insert into class(Class) values ('" + cname + "')");
	//response.sendRedirect("csuccess.jsp");
        response.sendRedirect("classalreadyexist.jsp");
    }
%>