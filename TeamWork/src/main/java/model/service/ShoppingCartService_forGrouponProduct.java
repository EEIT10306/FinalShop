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

import model.bean.GroupImages;
import model.bean.GroupOrder;
import model.bean.GroupProduct;
import model.bean.Member;
import model.repository.GroupOrderDao;
import model.repository.GroupProductDao;
import model.repository.MemberDao;

@Service
@Transactional
public class ShoppingCartService_forGrouponProduct {

	@Autowired
	private GroupProductDao groupProductDaoImpl;

	@Autowired
	private MemberDao memberDapImpl;

	@Autowired
	private GroupOrderDao groupOrderDaoImpl;

//	以 product Id 查詢商品資料
	public GroupProduct showGroupProductInformation(GroupProduct groupProduct) {
		try {
			 GroupProduct product = groupProductDaoImpl.selectByPk(groupProduct.getgP_id());
			Set<GroupImages> images = product.getGroupImages();
			if (images.isEmpty()) {
				GroupImages img = new GroupImages();
				img.setgI_context("../images/user/product/001.jpg");
				img.setgP_id(product.getgP_id());
				Set<GroupImages> first = new HashSet<>();
				first.add(img);
				product.setGroupImages(first);
				System.out.println(product.getGroupImages());
			}
			if (!images.isEmpty()) {
				Iterator<GroupImages> imagelist = images.iterator();
				GroupImages img = imagelist.next();
				System.out.println(img);
				Set<GroupImages> first = new HashSet<>();
				first.add(img);
				product.setGroupImages(first);
				System.out.println(product.getGroupImages());
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
	public void addNewGroupOrder(GroupOrder groupOrder) {
		try {
			Integer productID = groupOrder.getgP_id();
			Integer memberID = groupOrder.getM_idOrder();
			if ((groupProductDaoImpl.selectByPk(productID) != null) && (memberDapImpl.selectByPk(memberID) != null)
					&& (groupOrder.getgO_amount() != null) && (groupOrder.getgO_sumPrice() != null)) {
				Date orderDate = new Date();
				groupOrder.setgO_stateId(55);
				groupOrder.setgO_time(orderDate);
				System.out.println(groupOrder);
				groupOrderDaoImpl.insert(groupOrder);
				System.out.println("order insert success.");
			} else {
				System.out.println("order insert fail.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
