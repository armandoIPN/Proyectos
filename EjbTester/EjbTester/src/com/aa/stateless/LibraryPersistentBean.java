/**
 * LibraryPersistentBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aa.stateless;

public interface LibraryPersistentBean extends java.rmi.Remote {
    public void addBook(com.aa.stateless.Book arg0) throws java.rmi.RemoteException;
    public void preDestroy() throws java.rmi.RemoteException;
    public com.aa.stateless.Book[] getBooksJDBC() throws java.rmi.RemoteException;
    public void postConstruct() throws java.rmi.RemoteException;
    public com.aa.stateless.Book[] getBooks() throws java.rmi.RemoteException;
    public void addBookJDBC(com.aa.stateless.Book arg0) throws java.rmi.RemoteException;
    public com.aa.stateless.Book[] getBooksEJBQL() throws java.rmi.RemoteException;
}
