package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupOrder;
import model.bean.StoreOrder;
import model.bean.Wish;
import model.bean.WishBid;
import model.bean.WishOrder;
import model.repository.GroupOrderDao;
import model.repository.StoreOrderDao;
import model.repository.WishBidDao;
import model.repository.WishDao;
import model.repository.WishOrderDao;

@Service
@Transactional
public class OrderService {

	@Autowired
	StoreOrderDao storeOrderDao;

	@Autowired
	WishOrderDao wishOrderDao;

	@Autowired
	WishBidDao wishBidDao;
	@Autowired
	WishDao wishDao;

	@Autowired
	GroupOrderDao groupOrderDao;

	public OrderService() {
	}

	// (商店)利用買家ID取得購買訂單資料
	public List<StoreOrder> getStoreOrder(StoreOrder storeOrder) throws SQLException {
		Integer MemberId = storeOrder.getM_idOrder();
		if (MemberId == null) {
			// 若無給予指定使用者ID則回傳全部
			return storeOrderDao.selectAll();
		} else {
			String hql = "WHERE memS_IDee =" + MemberId;
			return storeOrderDao.selectHql(hql);
		}
	}

	// 這個方法還有問題
	public List<StoreOrder> getStoreOrderByBuyerIdAndState(StoreOrder storeOrder) throws SQLException {
		Integer MemberId = storeOrder.getM_idOrder();
		Integer OrderState = storeOrder.getsO_stateId();
		String hql = "";
		if (MemberId == null && OrderState == null) {
			// 若無給予指定使用者ID與狀態ID則回傳全部
			System.out.println("1==============================================" + MemberId + ":" + MemberId);
			return storeOrderDao.selectAll();
		} else if (MemberId != null && OrderState == null) {
			System.out.println("2==============================================" + MemberId + ":" + MemberId);
			hql = "WHERE memS_IDee =" + MemberId;
			return storeOrderDao.selectHql(hql);
		} else if (MemberId == null && OrderState != null) {
			System.out.println("3==============================================" + MemberId + ":" + MemberId);
			hql = "WHERE sO_state =" + OrderState;
			return storeOrderDao.selectHql(hql);
		} else {
			System.out.println("4==============================================" + MemberId + ":" + MemberId);
			hql = "WHERE memS_IDee = " + MemberId + " AND sO_state = " + OrderState;
			return storeOrderDao.selectHql(hql);
		}
	}

	// (許願)利用買家ID取得購買訂單資料
	public List<WishOrder> getWishOrderByBuyerId(Wish wish) throws SQLException {
		Integer buyerId = wish.getM_id();
		List<WishOrder> list = new ArrayList<>();
		if (buyerId == null) {
			return null;
		}
		String hql = "WHERE m_id = " + buyerId;
		List<Wish> wishTemps = wishDao.selectHql(hql);
		for (int i = 0; i < wishTemps.size(); i++) {
			Integer wishID = wishTemps.get(i).getW_id();
			WishOrder WishOrderTemp = wishOrderDao.selectByPk(wishID);
			if (WishOrderTemp != null) {
				list.add(WishOrderTemp);
			}
		}
		return list;

	}

	// 取得所有許願資料
	public List<Wish> getWishByM_id(Wish wish) throws SQLException {
		Integer buyerId = wish.getM_id();
		if (buyerId == null) {
			return wishDao.selectAll();
		} else {
			String hql = "WHERE m_id = " + buyerId;
			return wishDao.selectHql(hql);
		}
	}

	// 取得許願競標資料
	public List<WishBid> getWishBidListByW_id(WishBid wishbid) throws SQLException {
		Integer w_id = wishbid.getW_id();
		if (w_id == null) {
			return wishBidDao.selectAll();
		} else {
			String hql = "WHERE w_id = " + w_id;
			return wishBidDao.selectHql(hql);
		}
	}

	// 利用使用者資料取得開團資料
	public List<GroupOrder> getGroupOrderListByM_idOrder(GroupOrder groupOrder) throws SQLException {
		Integer buyerId = groupOrder.getM_idOrder();
		if (buyerId == null) {
			return groupOrderDao.selectAll();
		} else {
			String hql = "WHERE m_idOrder = " + buyerId;
			return groupOrderDao.selectHql(hql);
		}
	}

}
