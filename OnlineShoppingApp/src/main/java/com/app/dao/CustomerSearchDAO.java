package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerSearchDAO {
public List<Customer> getAllCustomers() throws BusinessException;
	
	public List<Customer> getCustomersByFname(String fname) throws BusinessException;
	
	public List<Customer> getCustomersByLname(String lname) throws BusinessException;
	
	public Customer getCustomerByEmail(String email) throws BusinessException;

}
