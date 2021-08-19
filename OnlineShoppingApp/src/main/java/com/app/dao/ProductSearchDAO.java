package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductSearchDAO {
	
 //   public List<Product> getProductsByName(String name) throws BusinessException;
	
	//public Product getProductById(int id) throws BusinessException;
	
	public List<Product> getAllProducts() throws BusinessException;

}
