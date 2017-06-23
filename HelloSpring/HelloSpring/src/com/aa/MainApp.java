package com.aa;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.apache.log4j.Logger;

public class MainApp {
	
	static Logger log = Logger.getLogger(MainApp.class.getName());
	
   public static void main(String[] args) {
	   AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	   
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
	   
	   /*AbstractApplicationContext ctx = 
		         new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		   
	   ctx.start();
		      HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		      helloWorld.setMessage("Hello World!");
		      helloWorld.getMessage();
		      ctx.stop();*/
	   
	   /*AbstractApplicationContext ctx = 
		         new AnnotationConfigApplicationContext(TextEditorConfig.class);

		      TextEditor te = ctx.getBean(TextEditor.class);
		      te.spellCheck();*/
	   
      //context.registerShutdownHook();
	   
	   /*CustomEventPublisher cvp = 
		         (CustomEventPublisher) context.getBean("customEventPublisher");
		      
		      cvp.publish();  
		      cvp.publish();*/
	   /*Student student = (Student) context.getBean("student");
	      student.getName();
	      student.getAge();
	      student.printThrowException();*/
	   
	   /*StudentDAO studentJDBCTemplate = 
		         (StudentDAO)context.getBean("studentJDBCTemplate");
		      
		      System.out.println("------Records Creation--------" );
		      studentJDBCTemplate.create("Zara", 11);
		      studentJDBCTemplate.create("Nuha", 2);
		      studentJDBCTemplate.create("Ayan", 15);

		      System.out.println("------Listing Multiple Records--------" );
		      List<Student> students = studentJDBCTemplate.listStudents();
		      
		      for (Student record : students) {
		         System.out.print("ID : " + record.getId() );
		         System.out.print(", Name : " + record.getName() );
		         System.out.println(", Age : " + record.getAge());
		      }

		      System.out.println("----Updating Record with ID = 2 -----" );
		      studentJDBCTemplate.update(2, 20);

		      System.out.println("----Listing Record with ID = 2 -----" );
		      Student student = studentJDBCTemplate.getStudent(2);
		      System.out.print("ID : " + student.getId() );
		      System.out.print(", Name : " + student.getName() );
		      System.out.println(", Age : " + student.getAge());
*/		   
	   /*StudentMDAO studentJDBCTemplate = 
		         (StudentMDAO)context.getBean("studentJDBCTemplate");
		      
		      System.out.println("------Records creation--------" );
		      studentJDBCTemplate.create("Zara", 11, 99, 2010);
		      studentJDBCTemplate.create("Nuha", 20, 97, 2010);
		      studentJDBCTemplate.create("Ayan", 25, 100, 2011);

		      System.out.println("------Listing all the records--------" );
		      List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		      
		      for (StudentMarks record : studentMarks) {
		         System.out.print("ID : " + record.getId() );
		         System.out.print(", Name : " + record.getName() );
		         System.out.print(", Marks : " + record.getMarks());
		         System.out.print(", Year : " + record.getYear());
		         System.out.println(", Age : " + record.getAge());
		      }*/
	   
	   log.info("Going to create HelloWord Obj");
	      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	      obj.getMessage();
	      
	      log.info("Exiting the program");
    
   }
}