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

	public int create(String newrecord) throws RemoteException {
		int rid = db.create(newrecord);
		System.out.println("create returned: " +rid);
		//might need error handling
		return rid;
	}
	
	public String read(int rid) throws RemoteException {
		String result = db.read(rid);
		if(result == null){
			System.out.println("record does not exist");
		}
		else
			System.out.println(result);
		return result;
	}
	
	public void update(int rid,String newrecord) throws RemoteException {
		String result = db.read(rid);
		if(result == null){
			System.out.println("record does not exist");
		}
		else{
			System.out.println(result);
		}
		System.out.println(db.update(rid,newrecord));
	}
	
	public void delete(int rid) throws RemoteException {
		System.out.println(db.delete(rid));
	}
}
