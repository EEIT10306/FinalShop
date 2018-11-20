package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Product;
import model.repository.ProductDao;

@Service
@Transactional
public class ProductCheageService {

	@Autowired
	private ProductDao productDaoImpl;

	public List<Product> getSelect(Product product) {
		String str;
		str = "Where p_parentsId = " + product.getP_id();
		try {
			List<Product> list = productDaoImpl.selectHql(str);
			return list;
		} catch (SQLException e) {
			System.err.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Product> getMainSelect() {
		String hql = "Where p_parentsId = null";
		try {
			List<Product> list = productDaoImpl.selectHql(hql);
			return list;
		} catch (SQLException e) {
			System.err.println("ProductCheageService - getMainSelect - SQLException");
			e.printStackTrace();
			return null;
		}
	}
	
}
