package teacher.add;

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
 * Servlet implementation class AddTeacher
 */
public class AddTeacher extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() 
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
	    String tname = request.getParameter("tname");
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
					"root", "");
			Statement st = con.createStatement();
			ResultSet s = st.executeQuery("select *from teacher where Teacher = '"+tname+"'");
	  
			if (!s.isBeforeFirst()) 
			{
				st.executeUpdate("insert into teacher(teacher) values ('" + tname + "')");
				response.sendRedirect("tsuccess.jsp");
	        } 
			else 
			{
	        response.sendRedirect("teacheralreadyexist.jsp");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
