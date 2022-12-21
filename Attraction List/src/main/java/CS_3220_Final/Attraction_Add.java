package CS_3220_Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Attraction_Add
 */
@WebServlet("/Attraction_Add")
public class Attraction_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attraction_Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Attraction_Add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String name = request.getParameter("c"); // name
		 String phone = request.getParameter("d"); // phone
		 
		 Connection c = null;
	    	try
	    	{
	    		String url  = "jdbc:mysql://cs3.calstatela.edu/cs3220stu61";
	    		String username = "cs3220stu61";
	    		String password = "PgzAZxFl92Fv";
	    		c = DriverManager.getConnection(url, username, password);
	    		Statement stmt = c.createStatement();
	    		ResultSet rs = stmt.executeQuery("select * from Attraction");
	    		PreparedStatement ps = c.prepareStatement("INSERT INTO Attraction (name,phone)" + "VALUES (?,?);");

	    		ps.setString(1, name);
	    		ps.setString(2, phone);
	    	
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
