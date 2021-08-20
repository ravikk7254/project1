package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartAddDAO {
	public int addToCart(String email , int pId) throws BusinessException;
}
