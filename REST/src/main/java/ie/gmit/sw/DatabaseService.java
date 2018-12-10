package ie.gmit.sw;

import java.rmi.*;

import ie.gmit.sw.models.Rental;

/*
 *  @author Sarah Carroll - G00330821
 * 
 *  DatabaseService RMI Interface
 * 
 */

// Creating Remote interface for Car Hire application 

public interface DatabaseService extends Remote {
	
	public int create(String newrecord) throws RemoteException;

	public String read(int rec) throws RemoteException;

	public int update(String updatedrec) throws RemoteException;

	public int delete(int rec) throws RemoteException;

//	public String status() throws RemoteException;
	
	public String test() throws RemoteException;
}
