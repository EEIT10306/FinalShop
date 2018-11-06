package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreCallback;
import model.bean.StoreMessage;
import model.repository.Impl.StoreCallbackDaoImpl;
import model.repository.Impl.StoreMessageDaoImpl;

@Service
@Transactional
public class StoreCallbackService {
	@Autowired
	StoreCallbackDaoImpl storeCallbackDaoImpl;
	
	public List<StoreCallback> selectAllStoreCallbackBySpId(Integer sP_id) throws SQLException{
		String hql = "Where storeMessage.sP_id = "+sP_id;
		hql += " Order By storeMessage.sM_time desc";
		System.out.println("12345");
		System.out.println(storeCallbackDaoImpl.selectHql(hql));
		return storeCallbackDaoImpl.selectHql(hql);
	}
}
