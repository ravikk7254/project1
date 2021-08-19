package com.app.dao.impl;

import java.util.List;

import com.app.dao.CartAddDAO;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class CartAddDAOImpl implements CartAddDAO {

	@Override
	public List<Cart> getAllOrders() throws BusinessException {
		
		return null;
	}

	@Override
	public List<Cart> getCustomerOrders(String email) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int placeOrder(int orderId, String email) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(int orderId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
