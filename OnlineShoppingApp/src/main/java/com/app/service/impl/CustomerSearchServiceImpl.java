package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.CustomerSearchService;

public class CustomerSearchServiceImpl implements CustomerSearchService{

	@Override
	public boolean checkFname(String fname) throws BusinessException {
boolean c = false;
		
		if(fname.matches("[a-zA-Z]{2,15}")) {
			c = true;
		}
		else {
			throw new BusinessException("First Name is Invalid: "+fname);
		}
		return c;
	}

	@Override
	public boolean checkLname(String lname) throws BusinessException {
	boolean c = false;
		
		if(lname.matches("[a-zA-Z]{2,15}")) {
			c = true;
		}
		else {
			throw new BusinessException("Last Name: "+lname);
		}
		
		return c;
	
	}

	@Override
	public boolean checkEmail(String email) throws BusinessException {
	boolean c = false;
		
		if(email.matches("[a-zA-Z0-9]{3,15}@[a-z]{3,15}.com")) {
			c = true;
		}
		else {
			throw new BusinessException("Email is Invalid: "+email);
		}
		
		return c;
	}

}
