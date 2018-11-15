package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreFavorite;
import model.bean.StoreProduct;
import model.bean.Wish;
import model.bean.WishFavorite;
import model.repository.WishDao;
import model.repository.WishFavoriteDao;
import model.repository.Impl.WishDaoImpl;

@Service
@Transactional
public class WishFavoriteService {
	@Autowired
	WishFavoriteDao wishFavoriteDaoImpl;
	@Autowired
	WishDao wishDaoImpl;
	
	public boolean checkWishProductFavorite(WishFavorite bean) throws SQLException {
		return (wishFavoriteDaoImpl.selectByPk(bean.getW_id())==null)?true:false;
	}
	
	public List<WishFavorite> getWishFavorite(WishFavorite bean) throws SQLException{
		String hql = "where m_idFavorite = "+bean.getM_idFavorite()+" and w_id = "+bean.getW_id();
		System.out.println(wishFavoriteDaoImpl.selectHql(hql));
		return wishFavoriteDaoImpl.selectHql(hql);
	}
	
	public WishFavorite insertOneWishFavorite(WishFavorite bean) throws SQLException {
		WishFavorite result = wishFavoriteDaoImpl.insert(bean);
		Wish wish = wishDaoImpl.selectByPk(result.getW_id());
		wish.setW_hot(wish.getW_hot()+1);
		if(result != null) {
			wishDaoImpl.update(wish);
		}
		return wishFavoriteDaoImpl.insert(bean);
	}

	public boolean deleteWishFavorite(WishFavorite bean) throws SQLException {
		boolean result = wishFavoriteDaoImpl.delete(bean);
		Wish wish = wishDaoImpl.selectByPk(bean.getW_id());
		wish.setW_hot(wish.getW_hot()-1);
		if(result != false) {
			wishDaoImpl.update(wish);
		}
		return wishFavoriteDaoImpl.delete(bean);
	}

	
}
