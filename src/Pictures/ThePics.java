package Pictures;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ThePics
 */
@WebServlet("/ThePics")
public class ThePics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThePics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n\n");
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jeff", "jeff", "jeff");
			Statement st = connection.createStatement();
			String qString = "select description from pictures order by description";
			ResultSet rs = st.executeQuery(qString);
			response.setContentType("text/plain; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        int i = 1;
	        while( rs.next() ) {
	        	out.println(rs.getString(i));
	        }
			// connection = DriverManager.getConnection(“the”, “cat”, “in”);
			// connection = DriverManager.getConnection(“jdbc:postgresql://localhost:5432/jeff”, “jeff”, “JHJTFSljp912”);

		} catch (SQLException e) {
			System.out.println("Hey how r ya\n");
			System.out.println("Sql Failed! Check output console \n" + e.getMessage());
			// System.out.println(“Connection Failed! Check output console”);
			e.printStackTrace();
			return;

		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
