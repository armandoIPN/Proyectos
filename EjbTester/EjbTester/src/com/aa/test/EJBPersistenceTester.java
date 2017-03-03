package com.aa.test;

import com.aa.entity.Author;
import com.aa.entity.Book;
import com.aa.entity.Publisher;
import com.aa.stateless.LibraryPersistentBean;
import com.aa.stateless.LibraryPersistentBeanRemote;
import com.aa.stateless.LibrarySessionBean;
import com.aa.stateless.LibrarySessionBeanRemote;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBPersistenceTester {

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

      EJBPersistenceTester ejbTester = new EJBPersistenceTester();

      ejbTester.testEntityEjb();
   }
   
   private void showGUI(){
      System.out.println("**********************");
      System.out.println("Welcome to Book Store");
      System.out.println("**********************");
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
   }
   
   private void testEntityEjb(){

      try {
         int choice = 1; 

         final String appName = "";
         final String moduleName = "EjbComponent";
         final String distinctName = "";
         final String beanName = LibraryPersistentBean.class.getSimpleName();
         final String viewClassName = LibraryPersistentBeanRemote.class.getName();
         String name="ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

         LibraryPersistentBeanRemote libraryBean =
         (LibraryPersistentBeanRemote)ctx.lookup(name);

         while (choice != 2) {
            String bookName;
            String publisherName;
            String publisherAddress;
            String authorName;
            showGUI();
            String strChoice = brConsoleReader.readLine();
            choice = Integer.parseInt(strChoice);
            if (choice == 1) {
               System.out.print("Enter book name: ");
               bookName = brConsoleReader.readLine();
               System.out.print("Enter publisher name: ");
               publisherName = brConsoleReader.readLine();
               System.out.print("Enter publisher address: ");
               publisherAddress = brConsoleReader.readLine();
               System.out.print("Enter author name: ");
               authorName = brConsoleReader.readLine(); 
               Book book = new Book();
               book.setName(bookName);
               book.setPublisher(new Publisher(publisherName,publisherAddress));
               String xml = "<book><name>"+bookName+"</name></book>";                                        
               byte[] imageBytes = {0x32, 0x32,0x32, 0x32,0x32,
               0x32,0x32, 0x32,
               0x32, 0x32,0x32, 0x32,0x32, 0x32,0x32, 0x32,
               0x32, 0x32,0x32, 0x32,0x32, 0x32,0x32, 0x32
               };
               book.setImage(imageBytes);
               book.setXml(xml);
               Author author = new Author();
			   author.setName(authorName);
			   Set<Author> authors = new HashSet<Author>();
			   authors.add(author);
               book.setAuthors(authors);
               libraryBean.addBookJDBC(book);          
            } else if (choice == 2) {
               break;
            }
         }

         List<Book> booksList = libraryBean.getBooksEJBQL();

         System.out.println("Book(s) entered so far: " + booksList.size());
         int i = 0;
         for (Book book:booksList) {
            System.out.println((i+1)+". " + book.getName());
            System.out.println("Publication: "+book.getPublisher());
            byte[] imageByts = book.getImage();
            if(imageByts != null){
               System.out.print("image bytes: [");
               for(int j = 0; j < imageByts.length ; j++){
                  System.out.print("0x" 
                  + String.format("%x", imageByts[j]) +" ");
               }            
               System.out.println("]");
            }        
            System.out.println(book.getXml());
            System.out.print("Author: ");
            Author[] authors = (Author[])book.getAuthors().toArray();
            for(int j=0;j<authors.length;j++){
               System.out.println(authors[j]);
            }
            i++;
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