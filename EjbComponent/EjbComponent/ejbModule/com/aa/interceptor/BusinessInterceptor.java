package com.aa.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class BusinessInterceptor {
   @AroundInvoke
   public Object methodInterceptor(InvocationContext ctx) throws Exception
   {
      System.out.println("*** Intercepting call to LibraryBean method: " 
      + ctx.getMethod().getName());
      return ctx.proceed();
   }
}