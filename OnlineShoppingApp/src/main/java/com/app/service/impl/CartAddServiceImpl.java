package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.CartAddService;

public class CartAddServiceImpl implements CartAddService {

	@Override
	public boolean checkProductID(int cartId) throws BusinessException {
boolean c = false;
		
		if(cartId <1 || cartId>1000 ) {
			throw new BusinessException("Invalid ID: "+cartId+" entered");
		}
		else {
			c = true;
		}
		return c;
	}

}
