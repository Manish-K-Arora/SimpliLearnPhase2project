package masterlist;

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
 * Servlet implementation class MasterReport
 */
public class MasterReport extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterReport() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html"); 
        String c = request.getParameter("className");
        out.println("<html><body style=background:silver>");  

        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                    "root", "");  
            Statement stmt = con.createStatement(); 
            Statement st = con.createStatement();
            Statement ts = con.createStatement();

            ResultSet rs = stmt.executeQuery("select *from student where Class = '"+c+"'");
            ResultSet sub = st.executeQuery("select Subject from classsubject where Class = '"+c+"'");
            ResultSet t = ts.executeQuery("select Subject, Teacher from tcs where Class = '"+c+"'"); 
            out.println("<h3 align=center>"+ "Report of Class " + c + "</h3>");
            out.println("<div align=center>");
            out.println("<table border=1 width=50% height=15% style=background-color:aqua;align=center>");  
            out.println("<tr><th>STUDENT_ID</th><th>STUDENTS</th></tr>");
            
//            out.println("<tr><th>studid</th><th>Student</th><tr>");
            
            while(rs.next()) 
            {  
                int n = rs.getInt("studid");  
                String nm = rs.getString("Student");  
//                String s = sub.getString("Subject");   
                out.println("<tr><td align=center>" + n + "</td><td align=center>" + nm + "</td></tr>");
                
                
                
                //out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
//                out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");
            }  
            out.println("</div>");
            out.println("</table>");
            //con.close();
            
            out.println("<div align=center>");
            out.println("<table border=1 width=50% height=1% style=background-color:yellow>");
            out.println("<tr><th>SUBJECTS</th></tr>");
    
            while(sub.next()) 
            {
            	String s = sub.getString("Subject");
            	out.println("<tr><td align=center>" + s + "</td></tr>");
            }
//}
            out.println("</div>");
            out.println("</table>");
            out.println("<div align=center>");
            out.println("<table border=1 width=50% height=10% style=background-color:pink>");
            out.println("<tr><th>SUBJECTS</th><th>TEACHERS</th></tr>");
            
            while(t.next()) 
            {
            	String j = t.getString("Subject");
            	String k = t.getString("Teacher");
            	out.println("<tr><td align=center>" + j + "</td><td align=center>" + k + "</td></tr>");
            }
//}
            out.println("</div>");
            out.println("</table>");
            out.println("<form action=classreport.jsp>");
            out.println("<input type=submit value = 'GoBack'>");
            out.println("</form>");
            out.println("</html></body>");  
//con.close();  
           }  
            catch (Exception e) 
           {  
            	out.println("Exception while retrieving : " + e.getMessage());  
           } 
   	}  
}
