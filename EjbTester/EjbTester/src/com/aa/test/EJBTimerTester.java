package com.aa.test;

import com.aa.stateless.LibraryPersistentBean;
import com.aa.stateless.LibraryPersistentBeanRemote;
import com.aa.timer.TimerSessionBean;
import com.aa.timer.TimerSessionBeanRemote;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBTimerTester {

   BufferedReader brConsoleReader = null; 
   Properties props;
   InitialContext ctx;
   {
      props = new Properties();
      try {
         props.load(new FileInputStream("jndi.properties"));
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      try {
         ctx = new InitialContext(props);            
      } catch (NamingException ex) {
         ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   
   public static void main(String[] args) {

      EJBTimerTester ejbTester = new EJBTimerTester();

      ejbTester.testTimerService();
   }
   
   private void showGUI(){
      System.out.println("**********************");
      System.out.println("Welcome to Book Store");
      System.out.println("**********************");
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
   }
   
   private void testTimerService(){
      try {
    	  
    	  final String appName = "";
          final String moduleName = "EjbComponent";
          final String distinctName = "";
          final String beanName = TimerSessionBean.class.getSimpleName();
          final String viewClassName = TimerSessionBeanRemote.class.getName();
          String name="ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

         TimerSessionBeanRemote timerServiceBean = (TimerSessionBeanRemote)ctx.lookup(name);

         System.out.println("["+(new Date()).toString()+ "]" + "timer created.");
         timerServiceBean.createTimer(2000);            

      } catch (NamingException ex) {
         ex.printStackTrace();
      }
   }
}