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
	
	public Integer wPnameToID(String wpname) throws SQLException {
		
		String hql = "WHERE wP_name = '" +  wpname + "'";
		//取得商城商品資料
		System.out.println("WishPro=" + wishProductDaoImpl.selectHql(hql));
		// 去找店家家的ID 如果不是NULL就回傳ID
		for (WishProduct storebean : wishProductDaoImpl.selectHql(hql)) {
			return storebean.getwP_id();
		}
		return null;
		
	}

}
