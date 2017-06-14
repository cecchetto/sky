/**
 * CustomerLocationBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sky.CustomerLocationService;

import java.util.HashMap;
import java.util.Map;

public class CustomerLocationBindingImpl implements com.sky.CustomerLocationService.CustomerLocationPortType{
    public java.lang.String getCustromerServiceIdenfierLocation(java.lang.String customerID) throws java.rmi.RemoteException {
        
    	Map<String,String> simulationCustomerLocationInit = init();
        String locationID = null;
        if(simulationCustomerLocationInit.get(customerID) != null)
        	locationID = simulationCustomerLocationInit.get(customerID);
        else
        	locationID = "Failure exception";
		
        return locationID;
    }
    
    /**INIZIALIZE MAP SIMULATION**/
    private Map<String,String> init()
    {
    	Map<String,String> simulation = new HashMap<String,String>();
    	simulation.put("1", "LONDON");
    	simulation.put("2", "LIVERPOOL");
    	simulation.put("3", "LONDON");
    	simulation.put("4", "LIVERPOOL");
    	simulation.put("5", "LONDON");
    	simulation.put("6", "LONDON");
    	simulation.put("7", "LIVERPOOL");
    	simulation.put("8", "LONDON");
    	simulation.put("9", "LIVERPOOL");
    	
		return simulation;
    }

}
