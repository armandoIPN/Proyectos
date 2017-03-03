/**
 * LibraryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aa.stateless;

public class LibraryServiceLocator extends org.apache.axis.client.Service implements com.aa.stateless.LibraryService {

    public LibraryServiceLocator() {
    }


    public LibraryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LibraryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LibraryPersistentBeanPort
    private java.lang.String LibraryPersistentBeanPort_address = "http://User-PC:8080/EjbComponent/LibraryService/LibraryPersistentBean";

    public java.lang.String getLibraryPersistentBeanPortAddress() {
        return LibraryPersistentBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LibraryPersistentBeanPortWSDDServiceName = "LibraryPersistentBeanPort";

    public java.lang.String getLibraryPersistentBeanPortWSDDServiceName() {
        return LibraryPersistentBeanPortWSDDServiceName;
    }

    public void setLibraryPersistentBeanPortWSDDServiceName(java.lang.String name) {
        LibraryPersistentBeanPortWSDDServiceName = name;
    }

    public com.aa.stateless.LibraryPersistentBean getLibraryPersistentBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LibraryPersistentBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLibraryPersistentBeanPort(endpoint);
    }

    public com.aa.stateless.LibraryPersistentBean getLibraryPersistentBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aa.stateless.LibraryServiceSoapBindingStub _stub = new com.aa.stateless.LibraryServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLibraryPersistentBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLibraryPersistentBeanPortEndpointAddress(java.lang.String address) {
        LibraryPersistentBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.aa.stateless.LibraryPersistentBean.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aa.stateless.LibraryServiceSoapBindingStub _stub = new com.aa.stateless.LibraryServiceSoapBindingStub(new java.net.URL(LibraryPersistentBeanPort_address), this);
                _stub.setPortName(getLibraryPersistentBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LibraryPersistentBeanPort".equals(inputPortName)) {
            return getLibraryPersistentBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://stateless.aa.com/", "LibraryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://stateless.aa.com/", "LibraryPersistentBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LibraryPersistentBeanPort".equals(portName)) {
            setLibraryPersistentBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
