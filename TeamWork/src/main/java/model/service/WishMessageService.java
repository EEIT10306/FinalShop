package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishMessage;
import model.repository.WishMessageDao;

@Service
@Transactional
public class WishMessageService {
	@Autowired
	WishMessageDao wishMessageDaoImpl;
	
	public List<WishMessage> selectAllWishMessageByWId(Integer w_id) throws SQLException{
		String hql = " Where w_id = " +w_id;
		hql += " Order By wM_time desc";
//		System.out.println(wishMessageDaoImpl.selectHql(hql).get(0).getStoreProduct().getStoreImages());
		return wishMessageDaoImpl.selectHql(hql);
	}
	public WishMessage InsertOneWishMessage(WishMessage bean) throws SQLException {
		return wishMessageDaoImpl.insert(bean);
	}
}
