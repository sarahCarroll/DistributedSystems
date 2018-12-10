package ie.gmit.sw.REST;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.DatabaseService;
import ie.gmit.sw.RMI;
import ie.gmit.sw.models.Rental;

@Path("/resource")
public class MyResource {

	@POST
	@Path("/create2")
	public Response create2(Rental toChange) {

		// You are getting a rental object through http
		// Which you then pass RMI.create(toChange)
		// IF you want then you can get a bool or int in your case to see
		// whether it was complete and return a response.

		String str = toChange.getFirstname() + " " + toChange.getSurname() + " " + toChange.getStartdate() + " "
				+ toChange.getDays() + " " + toChange.getCartype();

		System.out.println("");

		return Response.status(201).entity("Success").build();

	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create")
	public int create(@FormParam("Surname") String sname, @FormParam("Firstname") String fname,
			@FormParam("City") String city, @FormParam("StartDate") String startDate, @FormParam("Days") String days,
			@FormParam("CarType") String ct) throws Exception {
		String newrec = "<rental><surname>" + sname + "</surname><firstname>" + fname + "</firstname>" + "<city>" + city
				+ "</city><startdate>" + startDate + "</startdate>" + "<days>" + days + "</days><cartype>" + ct
				+ "</cartype></rental>";
		System.out.println("In  getit function");
		System.out.println(newrec);
		int x = new RMI().create(newrec);
		System.out.println("Record added to database: " + x);

		return x;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_XML)
	@Path("/read")
	public String getRead(@FormParam("RID") int rid) throws Exception {

		String result = new RMI().read(rid);
		// System.out.println("In getit function");
		// System.out.println("Read Record");

		return result;

	}

	/*
	 * @PUT
	 * 
	 * @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN)
	 * 
	 * @Path("/update") public String update(@FormParam("RID") int rid) throws
	 * Exception { System.out.println("In  getUpdate function"); new
	 * RMI().update(rid,"hello"); System.out.println("Updated Record");
	 * 
	 * return "update";
	 * 
	 * }
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update")
	public String update(@FormParam("Surname") String sname, @FormParam("Firstname") String fname,
			@FormParam("City") String city, @FormParam("StartDate") String startDate, @FormParam("Days") String days,
			@FormParam("CarType") String ct) throws Exception {
		String newrec = "<rental><surname>" + sname + "</surname><firstname>" + fname + "</firstname>" + "<city>" + city
				+ "</city><startdate>" + startDate + "</startdate>" + "<days>" + days + "</days><cartype>" + ct
				+ "</cartype></rental>";
		System.out.println("In  getit function");
		System.out.println(newrec);
		String x = new RMI().update(newrec);
		System.out.println("Record added to database: " + x);

		return x;

	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete")
	public String getDelete(@FormParam("RID") int rid) throws Exception {
		System.out.println("In  getDelete function");
		new RMI().delete(rid);
		System.out.println("deleted Record");

		return "Deleted Record " + rid;

	}

	/*
	 * public Response getIt() throws MalformedURLException, RemoteException,
	 * Exception { System.out.println("in getit function");
	 * 
	 * //RMI rm = new RMI(); //rm.testGetData();
	 * 
	 * String msg = "Hello my name is Sarah"; return
	 * Response.status(201).entity(msg).build();
	 * 
	 * 
	 * 
	 * }
	 */
}
