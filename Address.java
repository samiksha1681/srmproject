package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Address
 */
public class Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("***init method executed***");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("***destroy method executed***");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Address Details are </h1>");
		out.println("<h2>Name:Bhanu </h2>");
		out.println("<h2>Street:Mytrivanam </h2>");
		out.println("<h2>City:Hyderabad</h2>");
		out.println("<h2>Designation:Software Engineer</h2>");
		
	}

}
