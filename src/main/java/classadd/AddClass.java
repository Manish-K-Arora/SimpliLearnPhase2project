package classadd;

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
 * Servlet implementation class AddClass
 */
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
	    String cname = request.getParameter("cname");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
					"root", "");
			Statement st = con.createStatement();
			ResultSet s = st.executeQuery("select *from class where Class = '"+cname+"'");
	    
			if(!s.isBeforeFirst())
			{
	    	//response.sendRedirect("success.jsp");
				st.executeUpdate("insert into class(Class) values ('" + cname + "')");
				response.sendRedirect("csuccess.jsp");
			}
	        else 
	        {
	        	response.sendRedirect("classalreadyexist.jsp");
	        }
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}