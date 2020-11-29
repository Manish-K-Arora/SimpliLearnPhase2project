package studentclassmapping;

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
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() 
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
		String studname = request.getParameter("studname");
		String cname = request.getParameter("cname");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
					"root", "");
			Statement st = con.createStatement();
			ResultSet s = st.executeQuery("select *from student where Student =  '"+studname+"' and Class = '"+cname+"'");

			if(!s.isBeforeFirst()) 
			{
				st.executeUpdate("insert into student(Student, Class) values ('" + studname + "' , '" + cname +"')");
				response.sendRedirect("studsuccess.jsp");
	    	
			} 
			else 
			{
	        response.sendRedirect("studentexist.jsp");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}