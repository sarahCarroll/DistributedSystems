package ie.gmit.sw.REST;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.DatabaseService;
import ie.gmit.sw.RMI;

@Path("/resource")
public class MyResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create")
	public String getIt() throws Exception
    {
		System.out.println("In  getit function");
    	new RMI().testGetData();
    	System.out.println("created Record");
    	
		return "connect";
    	
    }
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/read")
	public String getRead() throws Exception
    {
		System.out.println("In  getit function");
    	new RMI().testRead();
    	System.out.println("Read Record");
    	
		return "read";
    	
    }
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update")
	public String getUpdate() throws Exception
    {
		System.out.println("In  getUpdate function");
    	new RMI().testUpdate();
    	System.out.println("Updated Record");
    	
		return "update";
    	
    }
	
	/*public Response getIt() throws MalformedURLException, RemoteException, Exception {
	System.out.println("in getit function");
	
	//RMI rm = new RMI();
 	//rm.testGetData();

	String msg = "Hello my name is Sarah";
    return Response.status(201).entity(msg).build();
    
   
    
}*/
}
