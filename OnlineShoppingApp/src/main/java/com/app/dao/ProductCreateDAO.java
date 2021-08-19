package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductCreateDAO {
	public int createProduct(Product product) throws BusinessException;

}
