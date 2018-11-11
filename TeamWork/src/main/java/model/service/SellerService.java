package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Groupon;
import model.bean.Member;
import model.bean.Seller;
import model.bean.Store;
import model.bean.StoreAssess;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.repository.GrouponDao;
import model.repository.SellerDao;
import model.repository.StoreAssessDao;
import model.repository.StoreDao;
import model.repository.StoreOrderDao;
import model.repository.StoreProductDao;

@Service
@Transactional
public class SellerService {

	@Autowired
	GrouponDao grouponDao;
	@Autowired
	StoreProductDao storeProductDao;
	@Autowired
	SellerDao sellerDao;
	@Autowired
	StoreDao storeDao;
	@Autowired
	StoreOrderDao storeOrderDao;
	@Autowired
	StoreAssessDao storeAssessDao;
	public SellerService() {
	}

	// 用開團者ID取得開團資料清單
	public List<Groupon> getGrouponSellerListByM_id(Groupon groupon) throws SQLException {
		Integer seller_id = groupon.getSeller_id();
		if (seller_id == null) {
			return grouponDao.selectAll();
		} else {
			String hql = "WHERE seller_id = " + seller_id;
			return grouponDao.selectHql(hql);
		}
	}

	// 用會員ID取得商店上架商品的資料
	public List<StoreProduct> getStoreProductSellerListByM_id(Member member) throws SQLException {
		Integer m_id = member.getM_id();
		List<Seller> sellers = sellerDao.selectHql("WHERE m_id=" + m_id);
		if (sellers.size() != 0) {
			Integer seller_id = sellers.get(0).getSeller_id();
			List<Store> stores = storeDao.selectHql("WHERE seller_id=" + seller_id);
			if (stores.size() != 0) {
				Integer s_id = stores.get(0).getS_id();
				return storeProductDao.selectHql("WHERE s_id=" + s_id);
			}
		}
		return null;
	}

	// 用會員ID取得該使用者之商店的訂單資料(賣家)
	public List<StoreOrder> getStoreOrderSellerListByM_id(Member member) throws SQLException {
		ArrayList <StoreOrder> storeOrders = new ArrayList();
		Integer m_id = member.getM_id();
		List<Seller> sellers = sellerDao.selectHql("WHERE m_id=" + m_id);
		if (sellers.size() != 0) {
			Integer seller_id = sellers.get(0).getSeller_id();
			List<Store> stores = storeDao.selectHql("WHERE seller_id=" + seller_id);
			if (stores.size() != 0) {
				Integer s_id = stores.get(0).getS_id();
				List<StoreProduct> temps = storeProductDao.selectHql("WHERE s_id=" + s_id);
				if (temps.size() != 0) {
					for (int i = 0; i < temps.size(); i++) {
						Integer sP_id = temps.get(i).getsP_id();
						storeOrders.addAll(storeOrderDao.selectHql ("WHERE sP_id="+sP_id));
					}
					return storeOrders;
				}
			}
		}
		return null;
	}
}
