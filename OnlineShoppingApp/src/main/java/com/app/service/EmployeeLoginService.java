package com.app.service;

import com.app.exception.BusinessException;

public interface EmployeeLoginService {
public boolean checkUserName(String username) throws BusinessException;
	
	public boolean checkPassword(String password) throws BusinessException;
	

}
