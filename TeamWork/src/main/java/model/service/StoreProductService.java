package model.service;



import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreProduct;
import model.repository.StoreProductDao;

@Service
@Transactional
public class StoreProductService {
	
	@Autowired
	StoreProductDao storeProductDaoImpl;
	
	public StoreProduct selectByPk(int id) throws SQLException {
		System.out.println(storeProductDaoImpl.selectByPk(id).getStoreImages());
		return storeProductDaoImpl.selectByPk(id);
	}
}
