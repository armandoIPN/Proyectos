package com.aa.stateful;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;
import javax.ejb.*;
import javax.ejb.Stateful;

import com.aa.entity.Book;
 
@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {
    
   List<Book> bookShelf;    
 
   public LibraryStatefulSessionBean(){
      bookShelf = new ArrayList<Book>();
   }
 
   public void addBook(Book bookName) {
      bookShelf.add(bookName);
   }    
 
   public List<Book> getBooks() {
      return bookShelf;
   }
   
   @PostConstruct
   public void postConstruct(){
      System.out.println("LibraryStatefulSessionBean.postConstruct::"
         + " bean created.");
   }

   @PreDestroy
   public void preDestroy(){
      System.out.println("LibraryStatefulSessionBean.preDestroy:"
         + " bean removed.");
   }

   @PostActivate
   public void postActivate(){
      System.out.println("LibraryStatefulSessionBean.postActivate:"
         + " bean activated.");
   }

   @PrePassivate
   public void prePassivate(){
      System.out.println("LibraryStatefulSessionBean.prePassivate:"
         + " bean passivated.");
   }    
   
}