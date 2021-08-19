package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.CartAddService;

public class CartAddServiceImpl implements CartAddService {

	@Override
	public boolean checkProductID(int orderId) throws BusinessException {
boolean c = false;
		
		if(orderId <100 || orderId>1000 ) {
			throw new BusinessException("Invalid ID: "+orderId+" entered");
		}
		else {
			c = true;
		}
		return c;
	}

}
