package com.aa.stateless;

import com.aa.entity.Book;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface LibraryPersistentBeanRemote {

   void addBook(Book bookName);
   List<Book> getBooks();
   public void addBookJDBC(Book book);
   public List<Book> getBooksJDBC();
   public List<Book> getBooksEJBQL();
    
}