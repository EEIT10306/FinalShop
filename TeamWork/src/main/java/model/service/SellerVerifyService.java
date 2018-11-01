package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Seller;
import model.bean.Store;
import model.repository.SellerDao;
import model.repository.StoreDao;

@Service
@Transactional
public class SellerVerifyService {
	@Autowired
	SellerDao sellerDao;
	@Autowired
	StoreDao storeDao;

	public void VerifySellerData(Store store, Seller seller) throws SQLException {

		String hql = "WHERE m_id = " + seller.getM_id();
		Seller sellerTemp = null;

		List<Seller> sellerTemps = sellerDao.selectHql(hql);
		// 檢查賣家表格有無存在資料
		if (sellerTemps.size() == 0) {
			// 沒有就新增
			System.out.println("seller insert");
			sellerTemp = sellerDao.insert(seller);
		} else {
			// 存在唯一一筆就更新
			System.out.println("seller update");
			sellerTemp = sellerDao.update(sellerTemps.get(0), seller);
		}

		String hql2 = "WHERE seller_id = " + sellerTemp.getSeller_id();
		List<Store> storeTemps = storeDao.selectHql(hql2);
		// 檢查賣場表格有無存在資料
		store.setSeller_id(sellerTemp.getSeller_id());
		if (storeTemps.size() == 0) {
			// 沒有就新增
			System.out.println("store insert");
			storeDao.insert(store);
		} else {
			// 存在就更新
			System.out.println("store update");
			storeDao.update(storeTemps.get(0), store);
		}
	}
}
