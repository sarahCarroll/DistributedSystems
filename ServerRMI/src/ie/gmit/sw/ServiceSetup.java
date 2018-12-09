package ie.gmit.sw;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/*
 *  @author Sarah Carroll - G00330821
 * 
 *  Server Setup Service - to initialize RMI server
 * 
 */

public class ServiceSetup {

	private static final String host = "localhost";

	public static void main(String[] args) throws Exception {
		DatabaseService db = new DatabaseServiceImpl();

		LocateRegistry.createRegistry(1099);

		Naming.rebind("databaseService", db);

		System.out.println("Server Running");
	}

	// public static void main(String args[]) {
	// try {
	//
	// DatabaseService db = new DatabaseServiceImpl();
	//
	// LocateRegistry.createRegistry(1099);
	//
	// Naming.rebind("databaseService", db);
	//
	// System.out.println("Server Running");
	// // Instantiating the implementation class
	// DatabaseServiceImpl temp = new DatabaseServiceImpl();
	//
	// System.setProperty("java.security.policy", "file:./server.policy");
	//
	// if (System.getSecurityManager() == null) {
	// System.setSecurityManager(new SecurityManager());
	// }
	//
	// // Exporting the object of implementation class
	// // (here we are exporting the remote object to the stub)
	//
	// String rmiObjectName = "rmi://" + host + "/databaseservice";
	//
	// System.err.println("Re-Binding stub ..." + rmiObjectName);
	//
	// // Naming.rebind(rmiObjectName, temp);
	//
	// System.err.println("Car Hire Server ready ...");
	//
	// // System.err.println(temp.create("<xml>record 1</xml>")+" added");
	// // System.err.println(temp.create("<xml>record 2</xml>")+" added");
	// // System.err.println(temp.create("<xml>record 3</xml>")+" added");
	// // System.err.println(temp.update(456123,"<xml>record 1
	// // Updated</xml>"));
	// // System.err.println(temp.read(456123));
	// // System.err.println(temp.delete(456123));
	//
	// // System.err.println(temp.status());
	//
	// } catch (Exception e) {
	// System.err.println("Server exception: " + e.toString());
	// e.printStackTrace();
	// }
	//
	// }
}