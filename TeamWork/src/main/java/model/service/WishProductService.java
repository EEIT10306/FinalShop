package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Wish;
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
	
	public WishProduct selectWishProductByWId(Integer w_id) throws SQLException {
		return wishProductDaoImpl.selectByPk(w_id);
	}

	public List<WishProduct> selectWishProductsByWBean(Wish bean) throws SQLException{
		String hql = "where w_id = " + bean.getW_id();
//		hql += " Order by wP_id desc";
		System.out.println("123");
		List<WishProduct> list = wishProductDaoImpl.selectHql(hql);
		System.out.println(list.get(0));
		return list;
	}
}
