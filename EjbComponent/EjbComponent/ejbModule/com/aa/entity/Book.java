package com.aa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book implements Serializable{
    
   /**
	 * 
	 */
	private static final long serialVersionUID = -7290428255186055683L;
	private int id;
	private String name;
	private Publisher publisher;
	private byte[] image;   
	private String xml;
	private Set<Author> authors;
	
   public Book(){        
   }

   @Id
   @GeneratedValue(strategy= GenerationType.SEQUENCE)
   @Column(name="id")
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }    
   
   @Embedded
   @AttributeOverrides({
      @AttributeOverride(name = "name", 
         column = @Column(name = "PUBLISHER")),
      @AttributeOverride(name = "address", 
         column = @Column(name = "PUBLISHER_ADDRESS"))
   })
   public Publisher getPublisher() {
      return publisher;
   }

   public void setPublisher(Publisher publisher) {
      this.publisher = publisher;
   }    
   
   /*@Lob */@Basic(fetch= FetchType.EAGER) 
   public byte[] getImage() {
      return image;
   }

   public void setImage(byte[] image) {
      this.image = image;
   }

   @Lob @Basic(fetch= FetchType.EAGER)
   public String getXml() {
      return xml;
   }

   public void setXml(String xml) {
      this.xml = xml;
   }
   
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}
   , fetch = FetchType.EAGER)
   @JoinTable(name = "book_author",
   joinColumns = {@JoinColumn(name = "book_id")},
   inverseJoinColumns = {@JoinColumn(name = "author_id")})
   public Set<Author> getAuthors()
   	{
	   return authors;
   	}
   
   public void setAuthors(Set<Author> authors){
	   this.authors=authors;
   }
}