package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;

/*
 *  @author Sarah Carroll - G00330821
 * 
 *  DatabaseService RMI Implementation
 * 
 */

// Implementing the remote interface 
public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;

	private int createCount;
	private int readCount;
	private int updateCount;
	private int deleteCount;
	private int statusCount;

	private int dbchanged = 0;

	private final int minchanges = 2; // write to disk if > 2 items outstanding
	private final int baserec = 456123;

	private List<String> alist;

	protected DatabaseServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int create(String newrec) {
		// System.out.println("This is an example create method");
		createCount++;

		if (alist == null) {
			if (load() != 0)
				alist = new ArrayList<String>(); // Code added here to serialise
													// ArrayList from disk
		}

		alist.add(newrec); // This will add string at the end of List

		int recnum = baserec + (alist.size() - 1); // first record has id of
													// 456123

		dbchanged++;

		save();

		return recnum;

	}

	private int save() {

		System.out.println("In save() function - dbchanged = " + dbchanged);
		if (dbchanged > minchanges) {
			try {
				System.out.println("Saving file ...\n");
				FileOutputStream fos = new FileOutputStream("RENTALS.DAT");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(alist);
				oos.close();
				fos.close();
				dbchanged = 0;
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return -1;
			}

		}

		return 0;
	}

	@SuppressWarnings("unchecked")
	private int load() {

		alist = null; // start with blank slate!

		try {
			FileInputStream fis = new FileInputStream("RENTALS.DAT");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				alist = (ArrayList<String>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ois.close();
				return -1;
			}
			ois.close();
			fis.close();
			return 0;
		} catch (IOException ioe) {
			// ioe.printStackTrace();
			return -1;
		}
	}

	@Override
	public String test() throws RemoteException {
		return "Hello my name is sarah :)";
	}
}