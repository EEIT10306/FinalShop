package model.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreImages;
import model.bean.StoreProduct;
import model.repository.StoreProductDao;

@Service
@Transactional
public class ServiceStoreProductChangeForm {

	@Autowired
	private StoreProductDao storeProductDaoImpl;

	
	public List<StoreProduct> getStoreProductForm(String str) {
		try {
			List<StoreProduct> list = storeProductDaoImpl.selectHql(str);
			for(StoreProduct sp:list) {
				Iterator<StoreImages> it = sp.getStoreImages().iterator();
				while(it.hasNext()) {
					it.next().setStoreProduct(null);
					
				};
			}
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
}
