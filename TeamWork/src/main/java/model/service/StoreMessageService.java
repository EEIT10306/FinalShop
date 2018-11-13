package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreMessage;
import model.repository.StoreMessageDao;

@Service
@Transactional
public class StoreMessageService {
	@Autowired
	StoreMessageDao storeMessageDaoImpl;
	
	public List<StoreMessage> selectAllStoreMessageBySpId(Integer Sp_id) throws SQLException{
		String hql = " Where sP_id = " +Sp_id;
		hql += " Order By sM_time desc";
		System.out.println(storeMessageDaoImpl.selectHql(hql).get(0).getStoreProduct().getStoreImages());
		return storeMessageDaoImpl.selectHql(hql);
	}
	
	public StoreMessage insert(StoreMessage bean) throws SQLException {
		return storeMessageDaoImpl.insert(bean);
	}
}
