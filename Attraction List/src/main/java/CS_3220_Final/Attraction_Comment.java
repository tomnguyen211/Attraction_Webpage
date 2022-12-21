package CS_3220_Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Attraction_Comment
 */
@WebServlet("/Attraction_Comment")
public class Attraction_Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attraction_Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);		
		
		String id = request.getParameter("id"); // Id based on the database
		
		Connection c = null;
    	try
    	{
    		String url  = "jdbc:mysql://cs3.calstatela.edu/cs3220stu61";
    		String username = "cs3220stu61";
    		String password = "PgzAZxFl92Fv";
    		c = DriverManager.getConnection(url, username, password);
    		Statement stmt = c.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from Comments");
    		List<comments> entries = new ArrayList<comments>();
    		
    		while(rs.next())
    		{
    			if(rs.getInt("id_place") == Integer.parseInt(id))
    			{
    				comments entry = new comments();
        			entry.setId(rs.getInt("id"));
        			entry.setName(rs.getString("name"));
        			entry.setComment(rs.getString("comment"));
        			entry.setId(rs.getInt("id"));
        			entries.add(entry);
    			}    			    			    			
    		} 
    		
    		request.setAttribute( "entries_comment", entries );
    		
    		String name = "";    				
    		Statement stmt_1 = c.createStatement();
    		ResultSet rs_1 = stmt_1.executeQuery("select * from Attraction");
    		while(rs_1.next())
    		{
    			if(rs_1.getInt("id") == Integer.parseInt(id))
    			{
    				name = rs_1.getString("name");
    				break;
    			}
    		}
    		
    		request.setAttribute( "name", name );
    		session.setAttribute("Index", Integer.parseInt(id));
    	}
    	catch( SQLException e)
    	{
    		throw new ServletException(e);
    	}
    	finally
    	{
    		try
    		{
    			if (c != null) c.close();
    		}
    		catch (SQLException e)
    		{
    			throw new ServletException(e);
    		}
    	}
    	
    	request.getRequestDispatcher("/WEB-INF/Attraction_Comment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		 int index = (int) request.getSession().getAttribute("Index"); //id of session
		 String name = request.getParameter("a"); // name
		 String comment = request.getParameter("b"); // name
		 
		 Connection c = null;
	    	try
	    	{
	    		String url  = "jdbc:mysql://cs3.calstatela.edu/cs3220stu61";
	    		String username = "cs3220stu61";
	    		String password = "PgzAZxFl92Fv";
	    		c = DriverManager.getConnection(url, username, password);
	    		Statement stmt = c.createStatement();
	    		ResultSet rs = stmt.executeQuery("select * from Comments");
	    		PreparedStatement ps = c.prepareStatement("INSERT INTO Comments (name,comment,id_place)" + "VALUES (?,?,?);");

	    		ps.setString(1, name);
	    		ps.setString(2, comment);
	    		ps.setInt(3, index);
	    	
	    		ps.executeUpdate(); 
	    	}
	    	catch( SQLException e)
	    	{
	    		throw new ServletException(e);
	    	}
	    	finally
	    	{
	    		try
	    		{
	    			if (c != null) c.close();
	    		}
	    		catch (SQLException e)
	    		{
	    			throw new ServletException(e);
	    		}
	    	}
	    	
	    	response.sendRedirect("Attraction_Homepage");
	}

}
