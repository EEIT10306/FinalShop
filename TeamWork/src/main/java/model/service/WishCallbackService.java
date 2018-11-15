package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishCallback;
import model.repository.WishCallbackDao;

@Service
@Transactional
public class WishCallbackService {
	@Autowired
	WishCallbackDao wishCallbackDaoImpl;
	
	public List<WishCallback> selectAllWishMessageByWId(Integer w_id) throws SQLException{
		String hql = "Where wishMessage.w_id = "+w_id;
		hql += " Order By wishMessage.wM_time desc";
//		System.out.println(storeCallbackDaoImpl.selectHql(hql).get(0).getStoreMessage().getStoreProduct().getStoreImages());
		return wishCallbackDaoImpl.selectHql(hql);
	}
	
	public WishCallback insertOneWishCallback(WishCallback bean) throws SQLException {
		return wishCallbackDaoImpl.insert(bean);
	}
}
