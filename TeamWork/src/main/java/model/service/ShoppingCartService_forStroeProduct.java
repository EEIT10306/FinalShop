package model.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Member;
import model.bean.StoreFavorite;
import model.bean.StoreImages;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.repository.MemberDao;
import model.repository.StoreFavoriteDao;
import model.repository.StoreOrderDao;
import model.repository.StoreProductDao;

@Service
@Transactional
public class ShoppingCartService_forStroeProduct {

	@Autowired
	private StoreProductDao storeProductDaoImpl;

	@Autowired
	private MemberDao memberDapImpl;

	@Autowired
	private StoreOrderDao storeOrderDaoImpl;

	@Autowired
	private StoreFavoriteDao storeFavoriteDaoImpl;

//	以 product Id 查詢商品資料
	public StoreProduct showStoreProductInformation(StoreProduct storeProduct) {
		try {
			StoreProduct product = storeProductDaoImpl.selectByPk(storeProduct.getsP_id());
			Set<StoreImages> images = product.getStoreImages();
			if (images.isEmpty()) {
				StoreImages img = new StoreImages();
				img.setsI_context("../images/user/product/001.jpg");
				img.setsP_id(product.getsP_id());
				Set<StoreImages> first = new HashSet<>();
				first.add(img);
				product.setStoreImages(first);
				System.out.println(product.getStoreImages());
			}
			if (!images.isEmpty()) {
				Iterator<StoreImages> imagelist = images.iterator();
				StoreImages img = imagelist.next();
				System.out.println(img);
				Set<StoreImages> first = new HashSet<>();
				first.add(img);
				product.setStoreImages(first);
				System.out.println(product.getStoreImages());
			}
			System.out.println(product);
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	查詢會員資料
	public Member findMemberInformation(Member member) {
		String hql = "WHERE m_account = '" + member.getM_account() + "'";
		System.out.println(hql);
		List<Member> list = null;
		try {
			list = memberDapImpl.selectHql(hql);
			System.out.println(list);
			Member memberFound = list.get(0);
			return memberFound;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	輸入交易資料
	public void addNewStoreOrder(StoreOrder storeOrder) {
		try {
			Integer productID = storeOrder.getsP_id();
			Integer memberID = storeOrder.getM_idOrder();
			if ((storeProductDaoImpl.selectByPk(productID) != null) && (memberDapImpl.selectByPk(memberID) != null)
					&& (storeOrder.getsO_amount() != null) && (storeOrder.getsO_sumPrice() != null)
					&& (storeOrder.getsO_transport() != null) && (storeOrder.getsO_pay() != null)) {
				Date orderDate = new Date();
				storeOrder.setsO_stateId(16);
				storeOrder.setsO_time(orderDate);
				System.out.println(storeOrder);
				storeOrderDaoImpl.insert(storeOrder);
				System.out.println("order insert success.");
			} else {
				System.out.println("order insert fail.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	將商品加入到我的最愛清單中
	public StoreFavorite addIntoMyFavorite(StoreFavorite storeFavorite) {
		Integer memberID = storeFavorite.getM_idFavorite();
		Integer productID = storeFavorite.getsP_id();
		String hql = "WHERE m_idFavorite = " + memberID + " AND sP_id = " + productID;
		try {
			Member member = memberDapImpl.selectByPk(memberID);
			StoreProduct product = storeProductDaoImpl.selectByPk(productID);
			if (member != null && product != null) {
				List<StoreFavorite> favorites = storeFavoriteDaoImpl.selectHql(hql);
				if (favorites.size() == 0) {
					StoreFavorite storeFavoriteInserted = storeFavoriteDaoImpl.insert(storeFavorite);
					System.out.println(storeFavoriteInserted);
					return storeFavoriteInserted;
				} else {
					System.out.println("This store product is in my favorite list.");		
					return favorites.get(0);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
