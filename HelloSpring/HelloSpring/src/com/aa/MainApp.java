package com.aa;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
   public static void main(String[] args) {
	   //AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	   
	   /*XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("Beans.xml")); 
	      HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");    
	      obj.getMessage();*/
      
     /*context = new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");*/

      //objA.setMessage("I'm object A");
      //objA.getMessage1();
      /*
      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
      objB.getMessage();*/
	   
	      /*HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
	      objA.getMessage1();
	      objA.getMessage2();

	      HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
	      objB.getMessage1();
	      objB.getMessage2();
	      objB.getMessage3();*/
	   
	   /*TextEditor te = (TextEditor) context.getBean("textEditor");
	      te.spellCheck();*/
	   
	   /*JavaCollection jc=(JavaCollection)context.getBean("javaCollection");

	      jc.getAddressList();
	      jc.getAddressSet();
	      jc.getAddressMap();
	      jc.getAddressProp();*/
	   
	  /* Student student = (Student) context.getBean("student");
	      System.out.println("Name : " + student.getName() );
	      System.out.println("Age : " + student.getAge() );*/
	   
	  /* Profile profile = (Profile) context.getBean("profile");
	      profile.printAge();
	      profile.printName();*/
	   
	   AbstractApplicationContext ctx = 
		         new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		   
	   ctx.start();
		      HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		      helloWorld.setMessage("Hello World!");
		      helloWorld.getMessage();
		      ctx.stop();
	   
	   /*AbstractApplicationContext ctx = 
		         new AnnotationConfigApplicationContext(TextEditorConfig.class);

		      TextEditor te = ctx.getBean(TextEditor.class);
		      te.spellCheck();*/
	   
      //context.registerShutdownHook();
    
   }
}