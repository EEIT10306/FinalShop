package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupAssess;
import model.bean.GroupOrder;
import model.bean.Member;
import model.bean.StoreAssess;
import model.bean.StoreOrder;
import model.bean.Wish;
import model.bean.WishAssess;
import model.bean.WishBid;
import model.bean.WishOrder;
import model.repository.GroupAssessDao;
import model.repository.GroupOrderDao;
import model.repository.GrouponDao;
import model.repository.MemberDao;
import model.repository.SellerDao;
import model.repository.StoreAssessDao;
import model.repository.StoreDao;
import model.repository.StoreOrderDao;
import model.repository.StoreProductDao;
import model.repository.WishAssessDao;
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
	@Autowired
	GroupAssessDao groupAssessDao;
	@Autowired
	StoreAssessDao storeAssessDao;
	WishAssessDao wishAssessDao;
	@Autowired
	GrouponDao grouponDao;
	@Autowired
	StoreProductDao storeProductDao;
	@Autowired
	SellerDao sellerDao;
	@Autowired
	StoreDao storeDao;

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


	// (許願)利用買家ID取得購買訂單資料
	public List<WishOrder> getWishOrderByBuyerId(Wish wish) throws SQLException {
		// 接收會員ID
		Integer buyerId = wish.getM_id();
		System.out.println(buyerId);
		List<WishOrder> list = new ArrayList<>();
		if (buyerId == null) {
			return wishOrderDao.selectAll();
		}

		String hql = "WHERE m_id = " + buyerId;
		// 取得所有此會員的願望List
		List<Wish> wishTemps = wishDao.selectHql(hql);
		for (int i = 0; i < wishTemps.size(); i++) {
			// 取得願望資料的PK
			Integer wishID = wishTemps.get(i).getW_id();
			// 利用願望PK尋找對應的訂單資料
			WishOrder WishOrderTemp = wishOrderDao.selectByPk(wishID);
			if (WishOrderTemp != null) {
				list.add(WishOrderTemp);
			}
		}
		return list;

	}

	// 利用會員ID取得許願資料
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

	// 新增一筆跟團評價資料(買的人評)
	public GroupAssess giveAssess_GroupBuyer(GroupAssess groupAssess) throws SQLException {
		// 先確認在GroupAssess表格裡有無相同跟團訂單編號的評價資料
		Integer gO_id = groupAssess.getgO_id();
		if (gO_id != null) {
			String hql = "WHERE gO_id = " + gO_id;
			List<GroupAssess> groupAssessBeans = groupAssessDao.selectHql(hql);
			if (groupAssessBeans.size() == 0) {
				return groupAssessDao.insert(groupAssess);
			} else {
				GroupAssess groupAssessBean = groupAssessBeans.get(0);
				return groupAssessDao.update(groupAssessBean, groupAssess);
			}
		} else {
			return null;
		}
	}

	// 將開團訂單的狀態由待收貨轉為完成
	public GroupOrder confirmReceive_Group(GroupOrder groupOrder) throws SQLException {
		Integer gO_ID = groupOrder.getgO_id();
		if (gO_ID != null) {
			GroupOrder bean = groupOrderDao.selectByPk(gO_ID);
			bean.setgO_stateId(58);
			groupOrderDao.update(bean);
			return bean;
		}
		return null;
	}

	// 將商店訂單的狀態由待收貨轉為完成
	public StoreOrder confirmReceive_Store(StoreOrder storeOrder) throws SQLException {
		Integer sO_ID = storeOrder.getsO_id();
		if (sO_ID != null) {
			StoreOrder bean = storeOrderDao.selectByPk(sO_ID);
			bean.setsO_stateId(19);
			storeOrderDao.update(bean);
			return bean;
		}
		return null;
	}

	// 新增一筆商店訂單評價資料(買的人評)
	public StoreAssess giveAssess_StoreBuyer(StoreAssess storeAssess) throws SQLException {
		// 先確認在GroupAssess表格裡有無相同跟團訂單編號的評價資料
		System.out.println("giveAssess_StoreBuyer==========>"+storeAssess);
		Integer sO_id = storeAssess.getsO_id();
		if (sO_id != null) {
			String hql = "WHERE sO_id = " + sO_id;
			List<StoreAssess> storeAssessBeans = storeAssessDao.selectHql(hql);
			if (storeAssessBeans.size() == 0) {
				return storeAssessDao.insert(storeAssess);
			} else {
				StoreAssess groupAssessBean = storeAssessBeans.get(0);
				return storeAssessDao.update(groupAssessBean, storeAssess);
			}
		} else {
			return null;
		}
	}

	// 新增一筆跟團評價資料
	public WishAssess giveAssess_WishBuyer(WishAssess wishAssess) throws SQLException {
		// 先確認在GroupAssess表格裡有無相同跟團訂單編號的評價資料
		System.out.println(wishAssess);
		Integer wO_id = wishAssess.getwO_id();
		if (wO_id != null) {
			String hql = "WHERE wO_id = " + wO_id;
			List<WishAssess> wishAssessBeans = wishAssessDao.selectHql(hql);
			if (wishAssessBeans.size() == 0) {
				return wishAssessDao.insert(wishAssess);
			} else {
				WishAssess wishAssessBean = wishAssessBeans.get(0);
				return wishAssessDao.update(wishAssessBean, wishAssess);
			}
		} else {
			return null;
		}
	}

	// 將願望訂單的狀態由待收貨轉為完成
	public WishOrder confirmReceive_Wish(WishOrder wishOrder) throws SQLException {
		System.out.println(wishOrder);
		Integer wO_id = wishOrder.getwO_id();
		if (wO_id != null) {
			WishOrder bean = wishOrderDao.selectByPk(wO_id);
			bean.setwO_stateId(41);
			wishOrderDao.update(bean);
			return bean;
		}
		return null;
	}

	

}
