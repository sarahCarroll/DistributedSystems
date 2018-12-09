package ie.gmit.sw;

import java.rmi.*;

/*
 *  @author Sarah Carroll - G00330821
 * 
 *  DatabaseService RMI Interface
 * 
 */

// Creating Remote interface for Car Hire application 

public interface DatabaseService extends Remote {
	
	public int create(String newrec) throws RemoteException;

	public String read(int rec) throws RemoteException;

	public int update(int rec, String updatedrec) throws RemoteException;

//	public int delete(int rec) throws RemoteException;
//
//	public String status() throws RemoteException;
	
	public String test() throws RemoteException;
}
