package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerCreateDAO {
	public int createCustomer(Customer customer) throws BusinessException;

}
