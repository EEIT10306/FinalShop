package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishBid;
import model.repository.WishBidDao;

@Service
@Transactional
public class WishBidService {
	@Autowired
	WishBidDao wishBidDaoImpl;
	
	public List<WishBid> selectAllBidByWId(Integer w_id) throws SQLException{
		String hql = "where w_id = "+w_id;
		hql += " Order by wB_time desc";
		return wishBidDaoImpl.selectHql(hql);
	}
	public WishBid insertOneWishBid(WishBid bean) throws SQLException {
		return wishBidDaoImpl.insert(bean);
	}
}
