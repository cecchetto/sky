/**
 * CatalogProductBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sky.CatalogProductService;

import java.util.ArrayList;
import java.util.List;

import com.sky.bean.ProductBean;
import com.sky.util.GsonUtililty;

public class CatalogProductBindingImpl implements com.sky.CatalogProductService.CatalogProductPortType{
    public java.lang.String getCatalogProduct(java.lang.String in) throws java.rmi.RemoteException {
    	List<ProductBean> resultMatchsimulationLocationIDProducts = new ArrayList<ProductBean>();
		List<ProductBean> simulationLocationIDProducts = init();

		for(ProductBean product : simulationLocationIDProducts)
		{
			/**IF PRODUCTS HAS THE SAME LOCATION ID PASSED TO WEB SERVICE
			 * ADDING ALWAYS EMPTY LOCATION VALUE**/
			if(product.getLocation().equals(in) || product.getLocation().isEmpty())
				resultMatchsimulationLocationIDProducts.add(product);
		}

		/**TAKE A LIST OF PRODUCT BEANs RETURN REFERRED JSON**/
		return GsonUtililty.getJsonFromListObject(resultMatchsimulationLocationIDProducts);
    }
    
    /**INIZIALIZE MAP SIMULATION MAPPING Location ID WITH Products available**/
	private List<ProductBean> init()
	{
		List<ProductBean> simulation = new ArrayList<ProductBean>();
		ProductBean first = new ProductBean(ProductBean.SPORTS_CATEGORY,"Arsenal TV","LONDON");
		ProductBean second = new ProductBean(ProductBean.SPORTS_CATEGORY,"Chelsea TV","LONDON");
		ProductBean third = new ProductBean(ProductBean.SPORTS_CATEGORY,"Liverpool TV","LIVERPOOL");
		ProductBean fourth = new ProductBean(ProductBean.NEWS_CATEGORY,"Sky News","");
		ProductBean fifth = new ProductBean(ProductBean.NEWS_CATEGORY,"Sky Sports News","");

		simulation.add(first);
		simulation.add(second);
		simulation.add(third);
		simulation.add(fourth);
		simulation.add(fifth);
		
		return simulation;	
	}
}
