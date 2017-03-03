package com.aa.test;

import com.aa.entity.Book;
import com.aa.stateful.*;
import com.aa.stateless.LibrarySessionBean;
import com.aa.stateless.LibrarySessionBeanRemote;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
public class EJBStatefulTester {
 
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
         ctx = new InitialContext(props);            
      } catch (NamingException ex) {
         ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   
   public static void main(String[] args) {
 
      EJBStatefulTester ejbTester = new EJBStatefulTester();
 
      ejbTester.testStatelessEjb();
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
         final String appName = "";
         final String moduleName = "EjbComponent";
         final String distinctName = "";
         final String beanName = LibraryStatefulSessionBean.class.getSimpleName();
         final String viewClassName = LibraryStatefulSessionBeanRemote.class.getName();

         String name="ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful";
         LibraryStatefulSessionBeanRemote libraryBean =
         (LibraryStatefulSessionBeanRemote)ctx.lookup(name);
 
         while (choice != 2) {
            String bookName;
            showGUI();
            String strChoice = brConsoleReader.readLine();
            choice = Integer.parseInt(strChoice);
            if (choice == 1) {
               System.out.print("Enter book name: ");
               bookName = brConsoleReader.readLine();
               Book book = new Book();
               book.setName(bookName);
               libraryBean.addBook(book);          
            } else if (choice == 2) {
               break;
            }
         }
 
         List<Book> booksList = libraryBean.getBooks();
 
         System.out.println("Book(s) entered so far: " + booksList.size());
         int i = 0;
         for (Book book:booksList) {
            System.out.println((i+1)+". " + book.getName());
            i++;
         }       
         LibraryStatefulSessionBeanRemote libraryBean1 = 
            (LibraryStatefulSessionBeanRemote)ctx.lookup(name);
         List<Book> booksList1 = libraryBean1.getBooks();
         System.out.println(
            "***Using second lookup to get library stateful object***");
         System.out.println(
            "Book(s) entered so far: " + booksList1.size());
         for (int i1 = 0; i1 < booksList1.size(); ++i1) {
            System.out.println((i1+1)+". " + booksList1.get(i1));
         }		 
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }finally {
         try {
            if(brConsoleReader !=null){
               brConsoleReader.close();
            }
         } catch (IOException ex) {
            System.out.println(ex.getMessage());
         }
      }
   }
}