package com.verizon.employee.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.verizon.employee.beans.Employee;

public class EmployeeDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public void getDBConnection(){
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    conn= DriverManager.getConnection(url,"scott","tiger");
		System.out.println("Connected...");
	} 
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	} 
	}
	public void close() {
		try{
			conn.close();
	}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

public void addEmployee(Employee emp){
	getDBConnection();
	try {
		pst=conn.prepareStatement("insert into employee values(?,?,?)");
		pst.setInt(1,emp.getEmpcode());
		pst.setString(2, emp.getEmpname());
		pst.setDouble(3,emp.getSalary());
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void updateEmployee(Employee emp){
	getDBConnection();
	try{
		pst=conn.prepareStatement("update employee set salary=6000 where empcode=44");
		pst.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
}
}
	public void deleteEmployee(Employee emp){
		getDBConnection();
		try{
			pst=conn.prepareStatement("delete from employee where empcode=44");
			pst.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
	}
		public List<Employee> viewEmployee(){
			getDBConnection();
			List<Employee> employees=new ArrayList<>();
			try{
			pst=conn.prepareStatement("select * from employee");
			rs=pst.executeQuery();
			while(rs.next()){
				Employee emp=new Employee();
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setSalary(rs.getInt(3));
				employees.add(emp);
			}

			}
			catch (SQLException e) {
				e.printStackTrace();
		}
			return employees;	}
	
		public void display(Employee emp){
			try{
				getDBConnection();
			pst=conn.prepareStatement("select * from employee where empcode=?");
			pst.setInt(1,emp.getEmpcode());
			rs=pst.executeQuery();
			while(rs.next()){
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setSalary(rs.getInt(3));
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
		}
			finally{
				close();
			}
		
	
}
}
