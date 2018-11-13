package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreImages;
import model.repository.StoreImagesDao;
@Service
@Transactional
public class StoreImagesService {
	@Autowired
	StoreImagesDao storeImagesDaoImpl;
	
	public List<StoreImages> selectBySp_Id(Integer sP_id) throws SQLException{
		String hql = "where sP_id = " + sP_id;
		return storeImagesDaoImpl.selectHql(hql);
	}
}
