package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Override
	public boolean checkEmail(String email) throws BusinessException {
		boolean c= false;
		
		if(email.matches("[a-zA-Z0-9]{5,20}@[a-z]{3,10}.com")) {
			c= true;
		}
		else {
			throw new BusinessException("Invalid email : "+email);
		}
		
		return c;
	}

	@Override
	public boolean checkPassword(String password) throws BusinessException {
		boolean c = false;
		
		if(password.matches("[a-zA-Z]{5,10}")) {
			c = true;
		}
		else {
			throw new BusinessException("Invalid password: "+password);
		}
		
		return c;
	}
	
	
	
}
