package com.aa;

import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {
   @Bean 
   public HelloWorld helloWorld(){
      return new HelloWorld();
   }
   
   @Bean
   public CStartEventHandler cStartEventHandler(){
	   return new CStartEventHandler();
   }
   
   @Bean
   public CStopEventHandler cStopEventHandler(){
	   return new CStopEventHandler();
   }
   
}