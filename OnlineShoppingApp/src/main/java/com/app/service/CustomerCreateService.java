package com.app.service;

import com.app.exception.BusinessException;

public interface CustomerCreateService {
public boolean checkEmail(String email) throws BusinessException;
	
	public boolean checkFname(String fname) throws BusinessException;
	
	public boolean checkLname(String lname) throws BusinessException;
	
	public boolean checkPassword(String password) throws BusinessException;

}
