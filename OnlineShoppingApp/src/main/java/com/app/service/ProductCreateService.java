package com.app.service;

import com.app.exception.BusinessException;

public interface ProductCreateService {
	public boolean checkName(String name) throws BusinessException;

	public boolean checkId(int id) throws BusinessException;
	
	public boolean checkPrice(int price) throws BusinessException;

}
