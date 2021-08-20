package com.app.dao.impl;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.app.dao.CartAddDAO;
import com.app.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class CartAddDAOImpl implements CartAddDAO {

	@Override
	public int addToCart(String email, int pId) throws BusinessException {
	int cartId = 0;
		
		int t = 0;

		try (Connection connection = MySqlDbConnection.getConnection()) {
			
			String sql = "INSERT INTO cart(email, p_id) VALUES(?,?) ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, pId);
			
			t = preparedStatement.executeUpdate();
			
			if(t == 0) {
				throw new BusinessException("Product ID : "+pId+" not found");
			}
			else {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					cartId = resultSet.getInt(1);
				}
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Product ID "+pId+" doesn't exist");
		}
		return cartId;
	}

	

}
