package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Member;
import model.bean.Seller;
import model.bean.StoreOrder;
import model.repository.MemberDao;
import model.repository.StoreOrderDao;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	StoreOrderDao StoreOrderDao;
	@Autowired
	MemberDao memberDao;
	
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
}
