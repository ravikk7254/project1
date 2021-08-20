package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.ProductCreateDAO;
import com.app.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductCreateDAOImpl implements ProductCreateDAO {

	@Override
	public int createProduct(Product product) throws BusinessException {
int c = 0;
		
		try(Connection connection = MySqlDbConnection.getConnection()) {
			
			String sql = "INSERT INTO product(id, name, price) VALUES(?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			c = preparedStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal server error occurred.");
		}
		
		return c;
	}

}
