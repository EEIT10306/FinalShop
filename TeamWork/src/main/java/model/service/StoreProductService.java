package model.service;



import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreProduct;
import model.repository.Impl.StoreProductDaoImpl;

@Service
@Transactional
public class StoreProductService {
	
	@Autowired
	StoreProductDaoImpl storeProductDaoImpl;
	
	public StoreProduct selectByPk(int id) throws SQLException {
		return storeProductDaoImpl.selectByPk(id);
	}
}
