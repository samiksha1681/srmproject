import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class BillPayment
 */
public class BillPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String input="";
		String x[]={"Success,Payment Done","Failed"};
		try {
	Date dnow=new Date();
	SimpleDateFormat ft=new SimpleDateFormat("hh:mm:ss");
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/RESTfulExample/rest/json/metallica/post");
					int i=0,k=101;
					while(k<110)
			{
						while(i<2)
						{
						input = "{\"custid\":"+k+",\"activity\":"+x[i]+",\"time\":"+ft.format(dnow)+"}";
						Thread.sleep(600000);
						i++;
						}
						k++;
			}

			ClientResponse response1 = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response1.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response1.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response1.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}

}
