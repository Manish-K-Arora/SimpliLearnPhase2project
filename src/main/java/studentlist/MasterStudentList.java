package studentlist;

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
 * Servlet implementation class MasterStudentList
 */
public class MasterStudentList extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterStudentList() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html"); 
        String c = request.getParameter("className");
//        String c = request.getParameter("cname");
        out.println("<html><body bgcolor=silver>");  
        
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                    "root", "");  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select *from student where Class = '"+c+"'"); 
            out.println("<div align=center>");
            out.println("<table border=1 width=50% height=15%>");  
// out.println("<tr><th>studid</th><th>Student</th><th>Class</th><tr>");
            out.println("<tr><th>studid</th><th>Student</th><tr>");
            out.println("<h3>"+ "Students of Class " + c + "</h3>");
   
            while (rs.next()) 
            {  
                int n = rs.getInt("studid");  
                String nm = rs.getString("Student");  
 //String s = rs.getString("Class");   
                
//out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");
            }  
            
            out.println("</div>");
            out.println("</table>");
            out.println("<form action=chooseclass.jsp>");
            out.println("<input type=submit value = 'GoBack'>");
            out.println("</form>");
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            	out.println(e);  
           } 
    }  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
