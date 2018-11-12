package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreFavorite;
import model.repository.StoreFavoriteDao;
import model.repository.StoreProductDao;
@Service
@Transactional
public class StoreFavoriteService {
	@Autowired
	StoreFavoriteDao storeFavoriteDaoImpl;
	@Autowired
	StoreProductDao storeProductDaoImpl;
	
	public List<StoreFavorite> checkStoreProductFavorite(StoreFavorite bean) throws SQLException{
		String hql = "where m_idFavorite = "+bean.getM_idFavorite()+" and sP_id = "+bean.getsP_id();
		return storeFavoriteDaoImpl.selectHql(hql);
	}
	
	public StoreFavorite insertOneStoreFavorite(StoreFavorite bean) throws SQLException {
		StoreFavorite result = storeFavoriteDaoImpl.insert(bean);
		if(result != null) {
			result.getStoreProduct().setsP_hot(result.getStoreProduct().getsP_hot()+1);
			storeProductDaoImpl.update(result.getStoreProduct());
		}
		return storeFavoriteDaoImpl.insert(bean);
	}
	
	public boolean deleteOneStoreFavorite(StoreFavorite bean) throws SQLException{
		boolean result = storeFavoriteDaoImpl.delete(bean);
		if(result != false) {
			bean.getStoreProduct().setsP_hot(bean.getStoreProduct().getsP_hot()-1);
			storeProductDaoImpl.update(bean.getStoreProduct());
		}
		return storeFavoriteDaoImpl.delete(bean);
	}
}
