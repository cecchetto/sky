/**
 * CustomerLocationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sky.CustomerLocationService;

public class CustomerLocationServiceLocator extends org.apache.axis.client.Service implements com.sky.CustomerLocationService.CustomerLocationService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerLocationServiceLocator() {
    }


    public CustomerLocationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerLocationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerLocationPort
    private java.lang.String CustomerLocationPort_address = "http://localhost:8080/CustomerLocationService/";

    public java.lang.String getCustomerLocationPortAddress() {
        return CustomerLocationPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerLocationPortWSDDServiceName = "CustomerLocationPort";

    public java.lang.String getCustomerLocationPortWSDDServiceName() {
        return CustomerLocationPortWSDDServiceName;
    }

    public void setCustomerLocationPortWSDDServiceName(java.lang.String name) {
        CustomerLocationPortWSDDServiceName = name;
    }

    public com.sky.CustomerLocationService.CustomerLocationPortType getCustomerLocationPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerLocationPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerLocationPort(endpoint);
    }

    public com.sky.CustomerLocationService.CustomerLocationPortType getCustomerLocationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sky.CustomerLocationService.CustomerLocationBindingStub _stub = new com.sky.CustomerLocationService.CustomerLocationBindingStub(portAddress, this);
            _stub.setPortName(getCustomerLocationPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerLocationPortEndpointAddress(java.lang.String address) {
        CustomerLocationPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sky.CustomerLocationService.CustomerLocationPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sky.CustomerLocationService.CustomerLocationBindingStub _stub = new com.sky.CustomerLocationService.CustomerLocationBindingStub(new java.net.URL(CustomerLocationPort_address), this);
                _stub.setPortName(getCustomerLocationPortWSDDServiceName());
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
        if ("CustomerLocationPort".equals(inputPortName)) {
            return getCustomerLocationPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/CustomerLocationService/", "CustomerLocationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/CustomerLocationService/", "CustomerLocationPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerLocationPort".equals(portName)) {
            setCustomerLocationPortEndpointAddress(address);
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
