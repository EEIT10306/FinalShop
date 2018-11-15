package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupOrder;
import model.bean.Member;
import model.bean.StoreOrder;
import model.bean.WishOrder;
import model.repository.GroupOrderDao;
import model.repository.MemberDao;
import model.repository.StoreOrderDao;
import model.repository.WishOrderDao;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	StoreOrderDao StoreOrderDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	WishOrderDao wishOrderDao;
	@Autowired
	GroupOrderDao groupOrderDao;
	//取得商店訂單狀態
	public List<StoreOrder> ReadStoreOrderState(String account) {
		String hql = "WHERE m_account = '" + account + "'";
		List<Member> getAccount = null;
		// 先去取得會員資料
		try {
			getAccount = memberDao.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("MemberHave=" + getAccount);
		for (Member memberbean : getAccount) {
			String hqlfind = "WHERE m_idOrder = " + memberbean.getM_id();
			List<StoreOrder> storeOrderbean = null;
			try {
				storeOrderbean = StoreOrderDao.selectHql(hqlfind);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return storeOrderbean;
		}
		return null;	
	}
	//取得許願訂單狀態
	public List<WishOrder> ReadWishOrderState(String account) {
		String hql = "WHERE m_account = '" + account + "'";
		List<Member> getAccount = null;
		// 先去取得會員資料
		try {
			getAccount = memberDao.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("MemberHave=" + getAccount);
		for (Member memberbean : getAccount) {
			String hqlfind = "WHERE memW_IDee = " + memberbean.getM_id();
			List<WishOrder> wishOrderbean = null;
			try {
				wishOrderbean = wishOrderDao.selectHql(hqlfind);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return wishOrderbean;
		}
		return null;	
	}
	//取得開團訂單狀態
	public List<GroupOrder> ReadGroupOrderState(String account) {
		String hql = "WHERE m_account = '" + account + "'";
		List<Member> getAccount = null;
		// 先去取得會員資料
		try {
			getAccount = memberDao.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("MemberHave=" + getAccount);
		for (Member memberbean : getAccount) {
			String hqlfind = "WHERE memG_IDee = " + memberbean.getM_id();
			List<GroupOrder> groupOrderbean = null;
			try {
				groupOrderbean = groupOrderDao.selectHql(hqlfind);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return groupOrderbean;
		}
		return null;	
	}
}
