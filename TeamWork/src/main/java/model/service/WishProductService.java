package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishProduct;
import model.repository.WishProductDao;

@Service
@Transactional
public class WishProductService {
	
	@Autowired
	WishProductDao wishProductDaoImpl;
	
	public WishProduct insert(WishProduct bean) {
		try {
			return wishProductDaoImpl.insert(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
		
	}

}
