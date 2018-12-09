package ie.gmit.sw.REST;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.DatabaseService;
import ie.gmit.sw.RMI;

@Path("/resource")
public class MyResource {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create")
	public int create(@FormParam("Surname") String sname,
						 @FormParam("Firstname") String fname,
						 @FormParam("City") String city,
						 @FormParam("StartDate") String startDate,
						 @FormParam("Days") String days,
						 @FormParam("CarType") String ct
						 ) throws Exception
    {
		String newrec = "<rental><surname>" + sname + "</surname><firstname>" + fname + "</firstname>"+ 
						"<city>" + city + "</city><startdate>" + startDate + "</startdate>"+ 
						"<days>" + days + "</days><cartype>" + ct + "</cartype></rental>";
		System.out.println("In  getit function");
		System.out.println(newrec);
    	int x  = new RMI().create(newrec);
    	System.out.println("Record added to database: " + x );
    	
		return x;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_XML)
	@Path("/read")
	public String getRead(@FormParam("RID") int rid) throws Exception
    {
		
		String result = new RMI().read(rid);
		//System.out.println("In  getit function");
    	//System.out.println("Read Record");
		
    	return result  ;
    	
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update")
	public String update(@FormParam("RID") int rid) throws Exception
    {
		System.out.println("In  getUpdate function");
    	new RMI().update();
    	System.out.println("Updated Record");
    	
		return "update";
    	
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete")
	public String getDelete(@FormParam("RID") int rid) throws Exception
    {
		System.out.println("In  getDelete function");
    	new RMI().delete(rid);
    	System.out.println("deleted Record");
    	
		return "Deleted Record " + rid ;
    	
    }
	
	/*public Response getIt() throws MalformedURLException, RemoteException, Exception {
	System.out.println("in getit function");
	
	//RMI rm = new RMI();
 	//rm.testGetData();

	String msg = "Hello my name is Sarah";
    return Response.status(201).entity(msg).build();
    
   
    
}*/
}
