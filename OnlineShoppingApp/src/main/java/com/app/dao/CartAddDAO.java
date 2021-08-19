package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartAddDAO {
public List<Cart> getAllOrders() throws BusinessException;
	
	public List<Cart> getCustomerOrders(String email) throws BusinessException;
	
	public int placeOrder(int orderId, String email) throws BusinessException;
	
	public int deleteOrder(int orderId) throws BusinessException;

}
