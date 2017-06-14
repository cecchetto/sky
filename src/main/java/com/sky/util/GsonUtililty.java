package com.sky.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sky.bean.ProductBean;

public class GsonUtililty {

	/**
	 * CONVERT LIST OF GENERIC OBJECT TO JSON
	 * @param objectsJson
	 * @return JSON
	 */
	public static String getJsonFromListObject(List<ProductBean> objectsList)
	{
		Gson gson = new Gson();
		// convert your list to json
		String jsonProductList = gson.toJson(objectsList);
		return jsonProductList;
	}
	
	/**
	 * CONVERT JSON TO LIST OF GENERIC OBJECT
	 * @param objectsJson
	 * @return LIST GENERIC OBJECT
	 */
	public static List<ProductBean> getListObjectFromJson(String json)
	{
		Gson gson = new Gson();
		List<ProductBean> prodList = gson.fromJson(json, new TypeToken<List<ProductBean>>(){}.getType());
		return prodList;
	}
}
