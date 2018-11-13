package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishFavorite;
import model.repository.WishFavoriteDao;

@Service
@Transactional
public class WishFavoriteService {
	@Autowired
	WishFavoriteDao wishFavoriteDaoImpl;
	
	public boolean checkWishProductFavorite(WishFavorite bean) throws SQLException {
		return (wishFavoriteDaoImpl.selectByPk(bean.getW_id())==null)?true:false;
	}
}
