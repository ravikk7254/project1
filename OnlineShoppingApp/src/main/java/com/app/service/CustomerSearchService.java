package com.app.service;

import com.app.exception.BusinessException;

public interface CustomerSearchService {

public boolean checkFname(String fname) throws BusinessException;
	
	public boolean checkLname(String lname) throws BusinessException;
	
	public boolean checkEmail(String email) throws BusinessException;
}
