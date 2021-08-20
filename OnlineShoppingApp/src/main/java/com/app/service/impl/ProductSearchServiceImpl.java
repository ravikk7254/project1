package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.ProductSearchService;

public class ProductSearchServiceImpl implements ProductSearchService {

	@Override
	public boolean checkName(String name) throws BusinessException {
boolean c = false;
		
		if(name.matches("[a-zA-Z]{2,20}")) {
			c = true;
		}
		else {
			throw new BusinessException("It seems you have entered invalid Product Name : "+name+" +Retry!!!" );
		}
		
		return c;
	}
	

	/*@Override
	public boolean checkId(int id) throws BusinessException {
boolean c = false;
		
		if(id <1 || id>1000 ) {
			throw new BusinessException("It seems you have entered invalid Product Id "+id+" +Retry!!!" );
		}
		else {
			c = true;
		}
		return c;
	}*/
	

}
