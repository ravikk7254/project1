package com.app.service;

import com.app.exception.BusinessException;

public interface CustomerLoginService {
public boolean checkEmail(String email) throws BusinessException;
	
	public boolean checkPassword(String password) throws BusinessException;
	

}
