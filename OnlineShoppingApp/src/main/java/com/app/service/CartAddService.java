package com.app.service;

import com.app.exception.BusinessException;

public interface CartAddService {
	public boolean checkProductID(int cartId) throws BusinessException;

}
