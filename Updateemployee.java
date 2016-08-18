package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.verizon.employee.beans.Employee;
import com.verizon.employee.dao.EmployeeDAO;

/**
 * Servlet implementation class Updateemployee
 */
public class Updateemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int code=Integer.parseInt(request.getParameter("code"));
		String name=request.getParameter("name");
		int salary=Integer.parseInt(request.getParameter("salary"));
		Employee emp=new Employee();
		emp.setEmpcode(code);
		emp.setEmpname(name);
		emp.setSalary(salary);
		EmployeeDAO dao=new EmployeeDAO();
		dao.updateEmployee(emp);
		out.println("record updated");
	}

}
