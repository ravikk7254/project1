package com.app.service.impl;

import com.app.exception.BusinessException;
import com.app.service.EmployeeLoginService;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	@Override
	public  boolean checkUserName(String i) throws BusinessException {
		
     boolean c = false;
		
		String empUser = "ravikumarlabh";
		
		if(i.equals(empUser)) {
			c= true;
		}
		else {
			throw new BusinessException("UserName is not Valid..please enter a valid one..: "+ i);
		}
		
		return c;
	}

	@Override
	public boolean checkPassword(String password) throws BusinessException {
boolean c = false;
		
		String empPassword = "ravikk9876";
		
		if(password.equals(empPassword)) {
			c = true;
		}
		else {
			throw new BusinessException("Password is not valid...please enter a valid one...:"+password);
		}
		
		return c;
	}

}
