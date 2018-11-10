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
}
