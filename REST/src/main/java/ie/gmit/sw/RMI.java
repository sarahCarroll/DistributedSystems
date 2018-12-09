package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI {
	
	private DatabaseService  db;
	
	public RMI() throws MalformedURLException, RemoteException, NotBoundException {
		 db = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");
		System.out.println("connection");
	}

	public void testGetData() throws RemoteException {
		System.out.println(db.create("Hello"));
		//System.out.println(db.create("hello"));
	}
	
	public void testRead() throws RemoteException {
		System.out.println(db.read(456154));
		//System.out.println(db.create("hello"));
	}
}