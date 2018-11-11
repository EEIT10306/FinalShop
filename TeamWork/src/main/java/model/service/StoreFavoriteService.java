package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreFavorite;
import model.repository.StoreFavoriteDao;
@Service
@Transactional
public class StoreFavoriteService {
	@Autowired
	StoreFavoriteDao storeFavoriteDaoImpl;
	
	public List<StoreFavorite> checkStoreProductFavorite(StoreFavorite bean) throws SQLException{
		String hql = "where m_idFavorite = "+bean.getM_idFavorite()+" and sP_id = "+bean.getsP_id();
		return storeFavoriteDaoImpl.selectHql(hql);
	}
	
	public StoreFavorite insertOneStoreFavorite(StoreFavorite bean) throws SQLException {
		return storeFavoriteDaoImpl.insert(bean);
	}
	
	public boolean deleteOneStoreFavorite(StoreFavorite bean) throws SQLException{
		boolean ok = storeFavoriteDaoImpl.delete(bean);
		System.out.println(ok);
		return ok;
	}
}
