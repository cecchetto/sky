/**
 * CustomerLocationBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sky.CustomerLocationService;

public class CustomerLocationBindingSkeleton implements com.sky.CustomerLocationService.CustomerLocationPortType, org.apache.axis.wsdl.Skeleton {
    private com.sky.CustomerLocationService.CustomerLocationPortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CustomerID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getCustromerServiceIdenfierLocation", _params, new javax.xml.namespace.QName("", "locationID"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://localhost:8080/CustomerLocationService/", "getCustromerServiceIdenfierLocation"));
        _oper.setSoapAction("http://localhost:8080/CustomerLocationService/getCustromerServiceIdenfierLocation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCustromerServiceIdenfierLocation") == null) {
            _myOperations.put("getCustromerServiceIdenfierLocation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCustromerServiceIdenfierLocation")).add(_oper);
    }

    public CustomerLocationBindingSkeleton() {
        this.impl = new com.sky.CustomerLocationService.CustomerLocationBindingImpl();
    }

    public CustomerLocationBindingSkeleton(com.sky.CustomerLocationService.CustomerLocationPortType impl) {
        this.impl = impl;
    }
    public java.lang.String getCustromerServiceIdenfierLocation(java.lang.String customerID) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getCustromerServiceIdenfierLocation(customerID);
        return ret;
    }

}
