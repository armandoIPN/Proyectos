package com.aa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Student {
	   private Integer age;
	   private String name;
	   private Integer id;

	   @Autowired(required=false)
	   public void setAge(Integer age) {
	      this.age = age;
	   }
	   public Integer getAge() {
	      return age;
	   }
	   
	   @Autowired
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }
	   
	   public void setId(Integer id) {
		      this.id = id;
		   }
		   public Integer getId() {
		      return id;
		   }
	   
	   public void printThrowException(){
		   System.out.println("Exception raised");
	      throw new IllegalArgumentException();
	   }
	}