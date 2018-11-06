package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreMessage;
import model.repository.Impl.StoreMessageDaoImpl;

@Service
@Transactional
public class StoreMessageService {
	@Autowired
	StoreMessageDaoImpl storeMessageDaoImpl;
	
	public List<StoreMessage> selectAllStoreMessageBySpId(Integer Sp_id) throws SQLException{
		String hql = " Where sP_id = " +Sp_id;
		hql += " Order By sM_time desc";
		return storeMessageDaoImpl.selectHql(hql);
	}
}
