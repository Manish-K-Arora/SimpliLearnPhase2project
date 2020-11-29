package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAdmin
 */
public class LoginAdmin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html"); 
        out.println("<html><body bgcolor=silver>");
		String userName = request.getParameter("userName");   
	    String password = request.getParameter("password");
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
	            "root", "");
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from users where username='" + userName + "' and password='" +password + "'");
	        
	        if (rs.next()) 
	        {
	        	response.sendRedirect("success.jsp");
	        } 
	        else 
	        {
	        	out.println("<div align=center>");
	        	out.println("<h3>Oops...Invalid Username or Password</h3>");
	        	out.println("<form action=index.jsp>");
	        	out.println("<input align=center type=submit value='Try Again'>");
	        	out.println("</for m></div>");
	        	out.println("</body></html>");      
	        }
	    }
	    catch(Exception e) 
	    {
	    	out.println(e);
	    }
	}
}
