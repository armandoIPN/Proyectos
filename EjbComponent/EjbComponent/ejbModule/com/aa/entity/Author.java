package com.aa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author implements Serializable{
    
   private int id;
   private String name;

   public Author(){}

   public Author(int id, String name){
      this.id = id;
      this.name = name;
   }
   
   @Id  
   @GeneratedValue(strategy= GenerationType.SEQUENCE)
   @Column(name="author_id")
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

   public String toString(){
      return id + "," + name;
   }    
}
