package com.aa.stateless;

import com.aa.callback.BookCallbackListener;
import com.aa.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.*;
import javax.transaction.Transactional;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService(serviceName="LibraryService")
public class LibraryPersistentBean extends BookCallbackListener implements LibraryPersistentBeanRemote {
    
	/*DataSource ds;
	{
		String strDSName = "java:/postgresDS";  
		   Context ctx=null;
		   Connection con=null;
		try {
			ctx = new InitialContext();
			ds = (javax.sql.DataSource) ctx.lookup(strDSName); 
			con=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		finally{
				try {
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}*/
   public LibraryPersistentBean(){	   
   }

   @PersistenceContext(unitName="EjbComponentPU2")
   private EntityManager entityManager;         

   @Transactional
   public void addBook(Book book) {
      entityManager.persist(book);
   }    

   @WebMethod(operationName="getBooks")
   public List<Book> getBooks() {
	   List<Book> list=entityManager.createQuery("From Book").getResultList();
	   return list;
   }
   
   @PostConstruct
   public void postConstruct(){
      System.out.println("postConstruct:: LibraryPersistentBean session bean"
         + " created with entity Manager object: ");
   }

   @PreDestroy
   public void preDestroy(){
      System.out.println("preDestroy: LibraryPersistentBean session"
      + " bean is removed ");
   }
   
   public void addBookJDBC(Book book) {
	      Connection con = null;
	      String url = "jdbc:postgresql://localhost:5432/postgres";
	      String driver = "org.postgresql.Driver";

	      String userName = "postgres";
	      String password = "arman20adroPG";
	      List<Book> books = new ArrayList<Book>();
	      try {

	         Class.forName(driver).newInstance();
	         con = DriverManager.getConnection(url , userName, password);

	         PreparedStatement st = 
	         con.prepareStatement("insert into books(id,name) values(?,?)");
	         st.setInt(1,(int)System.currentTimeMillis());
	         st.setString(2,book.getName());

	         int result = st.executeUpdate();                

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } catch (InstantiationException ex) {
	         ex.printStackTrace();
	      } catch (IllegalAccessException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }    
	   }    

	   public List<Book> getBooksJDBC() {
	      Connection con = null;
	      String url = "jdbc:postgresql://localhost:5432/postgres";
	      String driver = "org.postgresql.Driver";
	   
	      String userName = "postgres";
	      String password = "arman20adroPG";
	      List<Book> books = new ArrayList<Book>();
	      try {

	         Class.forName(driver).newInstance();
	         con = DriverManager.getConnection(url , userName, password);

	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery("select * from books");

	         Book book;
	         while (rs.next()) {
	            book = new Book();
	            book.setId(rs.getInt(1));                 
	            book.setName(rs.getString(2));
	            books.add(book);
	         }
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } catch (InstantiationException ex) {
	         ex.printStackTrace();
	      } catch (IllegalAccessException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	      return books;
	   }
	   
	   public List<Book> getBooksEJBQL() {
		      //create an ejbql expression
		      String ejbQL = "From Book b where b.name like ?1";
		      //create query
		      Query query = entityManager.createQuery(ejbQL);
		      //substitute parameter.
		      query.setParameter(1, "%ook%");   
		      //execute the query
		      return query.getResultList();
		   }   
}