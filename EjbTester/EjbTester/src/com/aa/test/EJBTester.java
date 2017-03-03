package com.aa.test;

import com.aa.stateless.LibrarySessionBean;
import com.aa.stateless.LibrarySessionBeanRemote;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.ejb.client.EJBClientContext;
import org.jboss.naming.remote.client.RemoteContext;
 
 
public class EJBTester {
 
   BufferedReader brConsoleReader = null; 
   Properties props;
   InitialContext ctx;
   {
      props = new Properties();
      try {
      props.load(new FileInputStream("jndi.properties"));
      } catch (IOException ex) {
      ex.printStackTrace();
      }
      try {
    	  final Hashtable jndiProperties = new Hashtable();
          jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
          jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
          //ctx = new InitialContext(jndiProperties);
          ctx = new InitialContext(props);            
      } catch (NamingException ex) {
      ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   public static void main(String[] args) {
 
      EJBTester ejbTester = new EJBTester();
 
      //ejbTester.testStatelessEjb();
      ejbTester.testDB();
   }
   private void showGUI(){
      System.out.println("**********************");
      System.out.println("Welcome to Book Store");
      System.out.println("**********************");
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
   }
   private void testStatelessEjb(){
      try {
         int choice = 1; 
         if(ctx==null)return;
         NamingEnumeration<Binding> binds=ctx.listBindings("");
         /*while(binds.hasMore()){
        	 Binding bind=binds.next();
        	 System.out.println(bind.getName());
         }*/
         
         /*RemoteContext remoteCtx = 
                 (RemoteContext)ctx.lookup("EjbComponent/remote");
         binds=remoteCtx.listBindings("");
         while(binds.hasMore()){
        	 Binding bind=binds.next();
        	 System.out.println(bind.getName());
         }*/
         final String appName = "";
         final String moduleName = "EjbComponent";
         final String distinctName = "";
         final String beanName = LibrarySessionBean.class.getSimpleName();
         final String viewClassName = LibrarySessionBeanRemote.class.getName();
         String name="ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
         LibrarySessionBeanRemote libraryBean = 
         (LibrarySessionBeanRemote)ctx.lookup(name);
         System.out.println(libraryBean);
         while (choice != 2) {
            String bookName;
            showGUI();
            String strChoice = brConsoleReader.readLine();
            choice = Integer.parseInt(strChoice);
            if (choice == 1) {
               System.out.print("Enter book name: ");
               bookName = brConsoleReader.readLine();                    
               libraryBean.addBook(bookName);          
            }else if (choice == 2) {
               break;
            }
         }
         List<String> booksList = libraryBean.getBooks();
         System.out.println("Book(s) entered so far: " + booksList.size());
         for (int i = 0; i < booksList.size(); ++i) {
         System.out.println((i+1)+". " + booksList.get(i));
         }
         for(int j=0;j<10;j++){
	         LibrarySessionBeanRemote libraryBean1 = 
	         (LibrarySessionBeanRemote)ctx.lookup(name);
	         List<String> booksList1 = libraryBean1.getBooks();
	         System.out.println(
	         "***Using second lookup to get library stateless object***");
	         System.out.println(
	         "Book(s) entered so far: " + booksList1.size());
	         for (int i = 0; i < booksList1.size(); ++i) {
	            System.out.println((i+1)+". " + booksList1.get(i));
	         }
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }finally {
         try {
            if(brConsoleReader !=null){
               brConsoleReader.close();
            }
            if(ctx!=null){
            	//ctx.close();
            }
         } catch (IOException ex) {
            System.out.println(ex.getMessage());
         } /*catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
      }
   }  
   
   public void testDB(){
	   DataSource ds = null;  
	   Connection con = null;  
	   Statement stmt = null;  
	   InitialContext ic;  
	      
	   try {    
	   ds = (DataSource) ctx.lookup("java:jboss/datasources/ExampleDS");  
	   con = ds.getConnection();  
	   /*stmt = con.createStatement();  
	   ResultSet rs = stmt.executeQuery("select * from tabname");  
	    
	   while (rs.next()) {  
	   System.out.println("<br> " + rs.getString("onecolumn") + " | "  
	   + rs.getString("othercolumn"));  
	   }  
	   rs.close();  
	   stmt.close();*/  
	   } catch (Exception e) {  
		   System.out.println("Exception thrown :/");  
		   e.printStackTrace();  
	   } finally {  
	     
	   try {
		   if (con != null) {
			   con.close();
			   }
		   } 
	   catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	     
	   }  
   }
}