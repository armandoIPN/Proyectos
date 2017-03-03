package com.aa.interceptor;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface LibraryBeanRemote {
   void addBook(String bookName);
   List getBooks();
}