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
import model.bean.StoreImages;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.bean.Wish;
import model.repository.GrouponDao;
import model.repository.SellerDao;
import model.repository.StoreAssessDao;
import model.repository.StoreDao;
import model.repository.StoreImagesDao;
import model.repository.StoreOrderDao;
import model.repository.StoreProductDao;
import model.repository.WishDao;

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
	@Autowired
	WishDao wishDao;
	@Autowired
	StoreImagesDao storeImagesDao;

	public SellerService() {
	}
	// 刪除此商品ID相關的全部圖片
	public void deleteStoreProductAllImagesById(StoreImages storeImages) {
		try {
			
			List<StoreImages> temps = storeImagesDao.selectHql("Where sP_id = " + storeImages.getsP_id());
			for(StoreImages temp : temps) {
				storeImagesDao.delete(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//下架商城商品資料
	public StoreProduct cancelStoreProduct(StoreProduct storeProduct) throws SQLException {
		Integer sP_id = storeProduct.getsP_id();
		StoreProduct temp = storeProductDao.selectByPk(sP_id);
		temp.setsP_stateId(15);
		return temp;
	}

	// 重新編輯商店商品資料
	public StoreProduct updateStoreProductData(StoreProduct storeProduct) throws SQLException {
		Integer sP_id = storeProduct.getsP_id();
		Integer sP_amount = storeProduct.getsP_amount();
		if (sP_id != null) {
			if(sP_amount==0) {
				storeProduct.setsP_stateId(14); //待補貨
			}else if(sP_amount>0) {
				storeProduct.setsP_stateId(13); //有現貨
				
			}
			StoreProduct SP = storeProductDao.selectByPk(sP_id);
			return storeProductDao.update(SP, storeProduct);
		}
		return null;
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
		ArrayList<StoreOrder> storeOrders = new ArrayList<StoreOrder>();
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
						storeOrders.addAll(storeOrderDao.selectHql("WHERE sP_id=" + sP_id));
					}
					return storeOrders;
				}
			}
		}
		return null;
	}

	// 編輯願望
	public Wish editWish(Wish wish) throws SQLException {
		Integer w_id = wish.getW_id();
		wish.setW_stateId(28);
		Wish bean = wishDao.selectByPk(w_id);
		return wishDao.update(bean, wish);
	}

	// 下架願望
	public Wish cancelWish(Wish wish) throws SQLException {
		Integer w_id = wish.getW_id();
		Wish bean = wishDao.selectByPk(w_id);
		bean.setW_stateId(31);
		return wishDao.update(bean);
	}
}
