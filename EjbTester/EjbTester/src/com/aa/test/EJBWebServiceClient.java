package com.aa.test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.aa.stateless.Book;

public class EJBWebServiceClient {
	public static void main(String[] args) {
	      for(com.aa.stateless.Book book:getBooks()){
	         System.out.println(book.getName());
	      }       
	   }

	   private static Book[] getBooks() {
	      com.aa.stateless.LibraryService service = 
	         new com.aa.stateless.LibraryServiceLocator();
	      com.aa.stateless.LibraryPersistentBean port;
		try {
			port = service.getLibraryPersistentBeanPort();
			return port.getBooks();
		} catch (ServiceException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return null; 
	   }      
}