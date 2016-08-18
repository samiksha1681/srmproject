package com.org.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;


@Path("/hello")
public class JerseyService2 {
	
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/hi")
public String sayPlainTextHello(final String input) {
	JSONObject json = new JSONObject(input);
	Transaction js2=new Transaction();
	int custid=Integer.parseInt(json.getString("customer_id"));
	
   System.out.println("Customer ID : "+custid);
  js2.setCustid(custid);
//System.out.println("Application: "+json.getString("application"));
   String act=json.getString("activity");
System.out.println("Activity : "+act);
js2.setAct(act);
String time=json.getString("time");
System.out.println("Time : "+time);
js2.setTime(time);
JerseyDAO js=new JerseyDAO();
js.add(js2);
//js.display();
js.view();
return "{\"result\": \"Hello world\"}";
    
    
}




}


