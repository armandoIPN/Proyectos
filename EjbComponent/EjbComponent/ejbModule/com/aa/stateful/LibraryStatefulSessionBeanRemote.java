package com.aa.stateful;

import java.util.List;
import javax.ejb.Remote;

import com.aa.entity.Book;
 
@Remote
public interface LibraryStatefulSessionBeanRemote {
   void addBook(Book bookName);
   List getBooks();
}