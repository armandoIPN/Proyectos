package com.aa.stateless;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.*;

/**
 * Session Bean implementation class LibrarySessionBean
 */

 
@Stateless
@EJB(name="java:jboss/exported/tutorialsPoint/librarySession",
beanInterface=LibrarySessionBeanLocal.class)
public class LibrarySessionBean implements LibrarySessionBeanRemote,LibrarySessionBeanLocal {
    
    List<String> bookShelf;    
    
    public LibrarySessionBean(){
       bookShelf = new ArrayList<String>();
    }
    
    @Override
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }    
 
    @Override
    public List<String> getBooks() {
        return bookShelf;
    }
}