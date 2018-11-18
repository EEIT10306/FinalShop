package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Member;
import model.bean.Seller;
import model.bean.Store;
import model.repository.MemberDao;
import model.repository.SellerDao;
import model.repository.StoreDao;

@Service
@Transactional
public class SellerVerifyService {
	@Autowired
	SellerDao sellerDao;
	@Autowired
	StoreDao storeDao;
	@Autowired
	MemberDao memberDao;

	// 商店驗證(商店驗證+賣家驗證)
	public Store VerifyStoreData(Store store, Seller seller) throws SQLException {
		
		if(seller.getM_id()==null) return null;
		
		// 檢查賣家表格有無存在資料
		String hql = "WHERE m_id = " + seller.getM_id();
		Seller sellerTemp = null;
		List<Seller> sellerTemps = sellerDao.selectHql(hql);
		if (sellerTemps.size() == 0) {
			// 沒有就新增
			System.out.println("seller insert======"+seller);
			sellerTemp = sellerDao.insert(seller);
			System.out.println(sellerTemp);
		} else {
			// 存在唯一一筆就更新
			System.out.println("seller update======"+seller);
			sellerTemp = sellerDao.update(sellerTemps.get(0), seller);
		}
		
		//利用上一段的回傳值sellerTemp取得賣家ID
		String hql2 = "WHERE seller_id = " + sellerTemp.getSeller_id();
		List<Store> storeTemps = storeDao.selectHql(hql2);
		// 檢查商店表格有無存在資料
		store.setSeller_id(sellerTemp.getSeller_id());
		if (storeTemps.size() == 0) {
			// 沒有就新增商店表格資料
			System.out.println("store insert======"+store);
			Store temp = storeDao.insert(store);
			System.out.println(temp);
			return temp;
		} else {
			// 存在就更新商店表格資料
			System.out.println("store update====="+store);
			return storeDao.update(storeTemps.get(0), store);
		}
	}

	// 只有賣家驗證
	public Seller VerifySellerData(Seller seller) throws SQLException {
		if(seller.getM_id()==null) return null;
		
		String hql = "WHERE m_id = " + seller.getM_id();

		List<Seller> sellerTemps = sellerDao.selectHql(hql);
		// 檢查賣家表格有無存在資料
		if (sellerTemps.size() == 0) {
			// 沒有就新增
			System.out.println("seller insert");
			return sellerDao.insert(seller);
		} else {
			// 存在唯一一筆就更新
			System.out.println("seller update");
			return sellerDao.update(sellerTemps.get(0), seller);
		}
	}

	// 會員Account驗證賣家會員ID
	public Integer AccountVerifySellerData(String account) {

		String hql = "WHERE m_account = '" + account + "'";
		List<Member> getAccount = null;
		// 先去取得會員資料
		try {
			getAccount = memberDao.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("MemberHave=" + getAccount);
		// 用會員的ID去找賣家的ID 如果不是NULL就回傳ID
		for (Member bean : getAccount) {
			String hqlfind = "WHERE m_id = " + bean.getM_id();
			List<Seller> sellerIdHave = null;
			try {
				sellerIdHave = sellerDao.selectHql(hqlfind);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (Seller sellbean : sellerIdHave) {
				if (sellbean.getSeller_id() != null) {
					return sellbean.getSeller_id();
				}
			}
		}
		return null;
	}

	// 賣家ID驗證個人店家
	public Integer accountVerifyStore(Integer SellerID) {

		String hql = "WHERE seller_id = " + SellerID;
		List<Store> getStore = null;
		// 去取得個人店家資料
		try {
			getStore = storeDao.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("StoreHave=" + getStore);
		// 去找店家的ID 如果不是NULL就回傳ID
		for (Store storebean : getStore) {
			if (storebean.getS_id() != null) {
				return storebean.getS_id();
			}
		}
		return null;

	}
}
