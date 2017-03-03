package com.aa.stateless;

public class LibraryPersistentBeanProxy implements com.aa.stateless.LibraryPersistentBean {
  private String _endpoint = null;
  private com.aa.stateless.LibraryPersistentBean libraryPersistentBean = null;
  
  public LibraryPersistentBeanProxy() {
    _initLibraryPersistentBeanProxy();
  }
  
  public LibraryPersistentBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initLibraryPersistentBeanProxy();
  }
  
  private void _initLibraryPersistentBeanProxy() {
    try {
      libraryPersistentBean = (new com.aa.stateless.LibraryServiceLocator()).getLibraryPersistentBeanPort();
      if (libraryPersistentBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)libraryPersistentBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)libraryPersistentBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (libraryPersistentBean != null)
      ((javax.xml.rpc.Stub)libraryPersistentBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.aa.stateless.LibraryPersistentBean getLibraryPersistentBean() {
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    return libraryPersistentBean;
  }
  
  public void addBook(com.aa.stateless.Book arg0) throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    libraryPersistentBean.addBook(arg0);
  }
  
  public void preDestroy() throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    libraryPersistentBean.preDestroy();
  }
  
  public com.aa.stateless.Book[] getBooksJDBC() throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    return libraryPersistentBean.getBooksJDBC();
  }
  
  public void postConstruct() throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    libraryPersistentBean.postConstruct();
  }
  
  public com.aa.stateless.Book[] getBooks() throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    return libraryPersistentBean.getBooks();
  }
  
  public void addBookJDBC(com.aa.stateless.Book arg0) throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    libraryPersistentBean.addBookJDBC(arg0);
  }
  
  public com.aa.stateless.Book[] getBooksEJBQL() throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    return libraryPersistentBean.getBooksEJBQL();
  }
  
  
}