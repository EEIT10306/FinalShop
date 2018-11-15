package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishBid;
import model.repository.StoreProductDao;
import model.repository.WishBidDao;


@Service
@Transactional
public class WishBidService {
	@Autowired
	WishBidDao wishBidDaoImpl;
	@Autowired
	private StoreProductDao storeProductDaoImpl;
	
	
	public List<WishBid> selectAllBidByWId(Integer w_id) throws SQLException{
		String hql = "where w_id = "+w_id;
		hql += " Order by wB_time desc";
		return wishBidDaoImpl.selectHql(hql);
	}
	public WishBid insertOneWishBid(WishBid bean) throws SQLException {
		return wishBidDaoImpl.insert(bean);

	}
	public List<WishBid> getWishForm(String search) {
		System.out.println("service"+search);
		String str = "";
		if (search != null) {
			str += "Where wish.w_title like '%" + search + "%' or wish.w_context like '%" + search + "%' ";
		}
//		as sp left join sp.product as pro left join sp.state as st
		try {
			List<WishBid> list = wishBidDaoImpl.selectHql(str);
//			for(StoreProduct sp:list) {
//				Iterator<StoreImages> it = sp.getStoreImages().iterator();
//				while(it.hasNext()) {
//					it.next().setStoreProduct(null);		
//				};
//			}
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
