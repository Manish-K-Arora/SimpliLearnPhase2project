package teacherclasssubjectmapping;

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
 * Servlet implementation class AssignTeacherClassSubject
 */
public class AssignTeacherClassSubject extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherClassSubject() 
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
		String cname = request.getParameter("cname");
		String subname = request.getParameter("subname");
		String tname = request.getParameter("tname");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
					"root", "");
			Statement st = con.createStatement();
			ResultSet s = st.executeQuery("select *from tcs where Class = '"+cname+"' and Subject =  '"+subname+"' and Teacher = '"+tname+"'");
	   	
			if(!s.isBeforeFirst()) 
			{
				st.executeUpdate("insert into tcs(Class , Subject, Teacher) values ('" + cname + "' , '" + subname + "' , '" + tname + "')");
				response.sendRedirect("tcssuccess.jsp");
	        } 
			else 
			{
	        response.sendRedirect("tcsexist.jsp");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}