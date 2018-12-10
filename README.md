# Distributed Systems

##Introduction
This project is a distributed system that keeps track of car rental bookings. This project was completed as part of 4th Year Computer in Software Development course in Galway Mayo Institute of technology. This document will discuss the design decisions of the project.


#### (A) Simple Web Client (Java JSP/Servlet or .NET equivalent if preferred)

Web client is the users interaction with the distributed system. It is in the REST Maven Project. The Web Client component is in src, main, webapp. The html files are executed when the user runs the application. It allows users to input data which is sent back to the server to either save/retrieve information. The users filled out web form is brought to the myresource page and a message is returned.


#### (B) RESTful Web Service (JAX-RS/Jersey)

The restful web service is all within the REST Maven Application. The Maven Project has the same package layout as the rmiServer this enables them to communicate.The databaseServer.java interface is in both projects in the package ie.gmit.sw. In the maven application in the ie.gmit.sw there is also a RMI.java. This class controls the calls to the databaseServer.

The ie.gmit.sw.REST package contains the MyResources.java. The create method pulls information from the html forms using JAX-RS @FormParam.
 
The parameters passed into the create() look like  "@FormParam("Firstname") String fname", etc.

The information is then saved into xml format e.g. 
"<rental><surname>" + sname + "</surname><firstname>" + fname + "</firstname>" + "<city>" + city+ "</city><startdate>" + startDate + "</startdate>" + "<days>" + days + "</days><cartype>" + ct+ "</cartype></rental>";". 

This is passed into the create() method in the RMI.java and that sends the information to databaseService, adding the information to the file and returning the new Rental Identifier RID).

#### (C) Data Modelling

Data modelling is an xml schema.The schema can then create Plain Old Java Objects (POJOs).
This is created in the command prompt using the command:

xjc -d C:\Users\sarah\Desktop\DSProject\distributedSystems -p ie.gmit.sw.Model "C:\Users\sarah\Desktop\DSProject\distributedSystems\RMI\src\ie\gmit\sw\Model\po.xsd". 

A new package called ie.gmit.sw.model is created and this contains the java classes. These are used to directly update the file/database.


#### (D) RMI Database Server

###### The remote interface called DatabaseServer.java exposes just 5 public methods.
	
These provide CRUD functionaility in Creating, Reading, Updating and Deleting data on the the underlying I/O subsystem. A 5th method, called status(), allows the caller to get some statistical data related to the I/O operations.

In this case a simple ArrayList has been used and is read/written from/to disk as it changes. The data read/written in each record is a basic Java String which contains the XML representation of the Card Rental record being processed.

This could be also wriiten to an SQL database again as a single String keyed by car rental record number or as individual fields in a database row or rows across several tables.

###### The DatabaseServerInterface.java extends UnicastRemoteObject implements DatabaseService 

The class creates methods for each of the called methods. The information in stored in a file called RENTALS.DAT. 
