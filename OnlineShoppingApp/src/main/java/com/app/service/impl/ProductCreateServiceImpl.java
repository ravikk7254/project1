package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.ProductCreateService;

public class ProductCreateServiceImpl implements ProductCreateService {

	@Override
	public boolean checkName(String name) throws BusinessException {
boolean c = false;
		
		if(name.matches("[a-zA-Z]{2,20}")) {
			c = true;
		}
		else {
			throw new BusinessException("Invalid name : "+name+" entered" );
		}
		
		return c;
	}

	@Override
	public boolean checkId(int id) throws BusinessException {
boolean c = false;
		
		if(id <1 || id>1000 ) {
			throw new BusinessException("Invalid ID: "+id+" entered");
		}
		else {
			c = true;
		}
		return c;
	}

	@Override
	public boolean checkPrice(int price) throws BusinessException {
boolean c = false;
		
		if(price < 1 || price> 1000000) {
			throw new BusinessException("Invalid Price Entered : "+price);
		}else {
			c = true;
		}
		
		return c;
	}

}
