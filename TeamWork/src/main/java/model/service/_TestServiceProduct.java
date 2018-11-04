package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Product;
import model.bean.WishMessage;
import model.repository.ProductDao;
import model.repository.WishMessageDao;

@Service
@Transactional
public class _TestServiceProduct {

	@Autowired
	private ProductDao productDaoImpl;

	public List<Product> getSelect(Product product) {
		String str;
		str = "Where p_parentsId = " + product.getP_id();
		try {
			List<Product> list = productDaoImpl.selectHql(str);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
		
	}

	
	
}
