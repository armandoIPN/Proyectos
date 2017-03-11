package com.aa;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	
	   private SpellChecker spellChecker;
	   /*private String name;
	   

	   public TextEditor() {
		super();
	   }*/
	   
	   
	public TextEditor(SpellChecker spellChecker) {
	      System.out.println("Inside TextEditor constructor." );
	      this.spellChecker = spellChecker;
	   }
	   
	   /*// a setter method to inject the dependency.
	@Resource(name = "spellChecker")
	   public void setSpellChecker(SpellChecker spellChecker) {
	      System.out.println("Inside setSpellChecker." );
	      this.spellChecker = spellChecker;
	   }
	   
	// a getter method to return spellChecker
	   public SpellChecker getSpellChecker() {
	      return spellChecker;
	   }
	   
	   public void setName(String name) {
		      this.name = name;
		   }
		   public String getName() {
		      return name;
		   }
	   */
	   public void spellCheck() {
	      spellChecker.checkSpelling();
	   }
	}
