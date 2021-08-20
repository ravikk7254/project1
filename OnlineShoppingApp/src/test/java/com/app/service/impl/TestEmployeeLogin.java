package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.service.EmployeeLoginService;

class TestEmployeeLogin {

	@Test
	void testCheckUserName() {
		EmployeeLoginService employeeLoginServiceImpl = new EmployeeLoginServiceImpl();
		try {
			 employeeLoginServiceImpl.checkUserName("ravikumarlabh11");
			 
			 fail("No Exception thrown");
		}catch (BusinessException e) {
			assertFalse(false);
		}
	}
	void testCheckUserPassword() {
		EmployeeLoginService employeeLoginServiceImpl = new EmployeeLoginServiceImpl();
		try {
			 employeeLoginServiceImpl.checkPassword("ravikk9876");
			 
			 fail("No Exception thrown");
		}catch (BusinessException e) {
			assertFalse(false);
		}
	}

}
