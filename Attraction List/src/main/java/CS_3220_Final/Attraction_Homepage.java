package CS_3220_Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class Attraction_Homepage
 */
@WebServlet("/Attraction_Homepage")
public class Attraction_Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attraction_Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);		
		if(session.getAttribute("Index") != null)
			session.removeAttribute("Index");
				
		Connection c = null;
    	try
    	{
    		String url  = "jdbc:mysql://cs3.calstatela.edu/cs3220stu61";
    		String username = "cs3220stu61";
    		String password = "PgzAZxFl92Fv";
    		c = DriverManager.getConnection(url, username, password);
    		Statement stmt = c.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from Attraction");
    		List<attraction> entries = new ArrayList<attraction>();
    		
    		while(rs.next())
    		{
    			attraction entry = new attraction();
    			entry.setId(rs.getInt("id"));
    			entry.setName(rs.getString("name"));
    			entry.setPhone(rs.getString("phone"));
    			   			
    			entries.add(entry);
    		} 
    		
    		request.setAttribute( "entries_attraction", entries );
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
    	
		request.getRequestDispatcher("/WEB-INF/Attraction_Homepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
