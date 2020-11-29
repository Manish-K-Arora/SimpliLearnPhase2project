package subject.add;

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
 * Servlet implementation class AddSubject
 */
public class AddSubject extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubject() 
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
			String subname = request.getParameter("subname");
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
						"root", "");
				Statement st = con.createStatement();
				ResultSet s = st.executeQuery("select *from subject where Subject = '"+subname+"'");
  
				if (!s.isBeforeFirst()) 
				{
					st.executeUpdate("insert into subject(Subject) values ('" + subname + "')");
					response.sendRedirect("subsuccess.jsp");
		        } 
				else 
				{
					response.sendRedirect("subjectalreadyexist.jsp");
				}
		  }
			catch(Exception e)
			{
				out.println(e);
			}
		}
}
