package com.org.jersey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.verizon.employee.beans.Employee;

public class JerseyDAO {
private Connection conn; 
private PreparedStatement pst;
private ResultSet rs;

public void getDBConnection(){
try {
	
Class.forName("oracle.jdbc.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
conn= DriverManager.getConnection(url,"system","manager");
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

public void add(Transaction js2){
getDBConnection();

try {
	Transaction a=js2;
	
pst=conn.prepareStatement("insert into CUSTOMER(customer_id,activity, time) values(?,?,?)");
System.out.println(a.getCustid());
pst.setInt(1,a.getCustid());
pst.setString(2,a.getAct());
pst.setString(3,a.getTime());
pst.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
}

public List<Transaction> view(){
getDBConnection();
List<Transaction> customer=new ArrayList<>();
try{
	Transaction emp=new Transaction();
pst=conn.prepareStatement("select * from CUSTOMER where activity='order'");
//pst.setString(1,emp.getAct());
rs=pst.executeQuery();
while(rs.next()){
	Transaction emp1=new Transaction();
emp1.setCustid(rs.getInt(1));
emp1.setAct(rs.getString(2));
emp1.setTime(rs.getString(3));
customer.add(emp1);
}

}
catch (SQLException e) {
e.printStackTrace();
}
return customer; }

public void display(){
try{
	Transaction emp=new Transaction();
getDBConnection();
pst=conn.prepareStatement("select * from CUSTOMER where customer_id=?");
pst.setInt(1,emp.getCustid());
rs=pst.executeQuery();
while(rs.next()){
emp.setCustid(rs.getInt(1));
emp.setAct(rs.getString(2));
emp.setTime(rs.getString(3));
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
