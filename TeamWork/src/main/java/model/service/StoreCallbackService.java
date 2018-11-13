package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreCallback;
import model.repository.StoreCallbackDao;

@Service
@Transactional
public class StoreCallbackService {
	@Autowired
	StoreCallbackDao storeCallbackDaoImpl;
	
	public List<StoreCallback> selectAllStoreCallbackBySpId(Integer sP_id) throws SQLException{
		String hql = "Where storeMessage.sP_id = "+sP_id;
		hql += " Order By storeMessage.sM_time desc";
		System.out.println(storeCallbackDaoImpl.selectHql(hql).get(0).getStoreMessage().getStoreProduct().getStoreImages());
		return storeCallbackDaoImpl.selectHql(hql);
	}
	
	public StoreCallback insertOneStoreCallback(StoreCallback bean) throws SQLException {
		return storeCallbackDaoImpl.insert(bean);
	}
	
	
}
