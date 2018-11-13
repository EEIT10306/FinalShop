package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishImages;
import model.bean.WishProduct;
import model.repository.WishImagesDao;

@Service
@Transactional
public class WishProductImagesSerivce {
	@Autowired
	WishImagesDao wishImagesDaoImpl;
	
	public List<WishImages> FindImagesByWishProductBean(WishProduct bean) throws SQLException {
		String hql = "where wP_id = "+bean.getwP_id();
		return wishImagesDaoImpl.selectHql(hql);
	}
}

