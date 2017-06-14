package com.sky.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.CatalogProductService.CatalogProductBindingImpl;
import com.sky.CustomerLocationService.CustomerLocationBindingImpl;
import com.sky.bean.CustomerIDBean;
import com.sky.bean.ProductBean;
import com.sky.util.GsonUtililty;

@Controller
public class SkyController {

	/**SIMULATE ASSOCIATION 
	 * CUSTOMER ID BEFORE OFFER PAGE
	 * 
	 * GET VALUE OF CUSTOMER WHEN GET ACCESS TO PORTAL 
	 * AND RETRIEVE PRODUCTS DERIVED FROM CUSTOMER ID AND LOCATION ID
	 * @throws Exception **/
	@RequestMapping("/preLoading")
	public ModelAndView preLoading() throws Exception {
		CustomerIDBean customerIDBean = new CustomerIDBean();
		String customerID = (int)(Math.random()*10)+"";
		
		
		String nomeCustomer = init(customerID);
		customerIDBean.setCustomerID(nomeCustomer);
		/**CALL FIRST STUB WEB SERVICE TO OBTAIN A LOCATION ID BASED ON CUSTOMER ID**/
		String locationID = null;
		CustomerLocationBindingImpl customerLocationService = new CustomerLocationBindingImpl();
		try {
			locationID = customerLocationService.getCustromerServiceIdenfierLocation(customerID);
			if(locationID.equals("Failure exception"))
			{
				System.out.println("Any Location found for this customerID: "+customerID);
			}
		} catch (RemoteException e) {
			throw new Exception("Something wrong happend calling WebService, message: "+e);
		}
		
		/**CALL SECOND STUB WEB SERVICE TO OBTAIN A LIST OF FILE PRODUCTS REFERRED TO THAT LOCATIONID**/
		String productsJsonList = null;
		
		CatalogProductBindingImpl catalogServiceByLocationIDService = new CatalogProductBindingImpl();
		productsJsonList = catalogServiceByLocationIDService.getCatalogProduct(locationID);
		// Converts JSON string into a List of Product object
		List<ProductBean> prodList = GsonUtililty.getListObjectFromJson(productsJsonList);
		/**DIVIDING ALL PRODUCT BASED ON CATERGORY**/
		List<ProductBean> sportsProdList = getCategoryProdFromList(prodList,ProductBean.SPORTS_CATEGORY);
		List<ProductBean> newsProdList = getCategoryProdFromList(prodList,ProductBean.NEWS_CATEGORY);
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("sportsProductList", sportsProdList);
		mv.addObject("newsProductList", newsProdList);
		mv.addObject("customerIDBean", customerIDBean);
		mv.addObject("resultWebServiceLocation",locationID);
		return mv;
	}

	/**
	 * GET CATEGORY TYPE AND RETURN A LIST OF PRODUCT OF REFERRED CATEGORY
	 * @param string
	 * @return
	 */
	private List<ProductBean> getCategoryProdFromList(List<ProductBean> prodList, String category) {
		List<ProductBean> productsFiltred = new ArrayList<ProductBean>();
		
		for(ProductBean productBean: prodList)
		{
			if(productBean.getCategory().equals(category))
				productsFiltred.add(productBean);
		}
		return productsFiltred;
	}
	
	@RequestMapping(value="/confirmation",method = RequestMethod.POST,headers="Accept=*/*",produces = "application/json")
	public @ResponseBody String confirmation(@RequestParam("values[]") List<String>[] customerIDProducts) throws JsonProcessingException  {
		
		List<String> result = new ArrayList<>();
		for(int i = 0; i < customerIDProducts.length ; i++)
		{
			result.add(customerIDProducts[i].get(0).replace("basket_", ""));
		}
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}
	
	 /**INIZIALIZE MAP SIMULATION CUSTOMER ID**/
    private String init(String customerID)
    {
    	Map<String,String> simulation = new HashMap<String,String>();
    	simulation.put("1", "Mark");
    	simulation.put("2", "Jhon");
    	simulation.put("3", "Mary");
    	simulation.put("4", "Adrian");
    	simulation.put("5", "Ciro");
    	simulation.put("6", "Maradona");
    	simulation.put("7", "Balotelli");
    	simulation.put("8", "Almerigo");
    	simulation.put("9", "Vasco");
    	simulation.put("10", "Charlie");
    	
		return simulation.get(customerID);
    }
}
