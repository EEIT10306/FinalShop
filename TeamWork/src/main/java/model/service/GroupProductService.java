package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupProduct;
import model.repository.GroupProductDao;

@Service
@Transactional
public class GroupProductService {
	
	@Autowired
	GroupProductDao groupProductDaoImpl;
	
	public GroupProduct insert(GroupProduct bean) {
		try {
			return groupProductDaoImpl.insert(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public Integer gPnameToID(String gpname) throws SQLException {
		
		String hql = "WHERE gP_name = '" +  gpname + "'";
		//取得商城商品資料
		System.out.println("GroupPro=" + groupProductDaoImpl.selectHql(hql));
		// 去找店家家的ID 如果不是NULL就回傳ID
		for (GroupProduct storebean : groupProductDaoImpl.selectHql(hql)) {
			return storebean.getgP_id();
		}
		return null;
		
	}
}
