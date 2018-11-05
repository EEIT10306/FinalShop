package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.GroupOrder;
import model.bean.StoreOrder;
import model.bean.Wish;
import model.bean.WishBid;
import model.bean.WishOrder;
import model.service.OrderService;

@Controller
public class OrderListController {

	@Autowired
	OrderService orderService;

	// 取得商店訂單資料
	@RequestMapping(value = "/StoreOrderList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<StoreOrder> getStoreOrderList(StoreOrder storeOrder) throws SQLException {
		return orderService.getStoreOrder(storeOrder);
	}

	// 取得商店訂單資料
	// 這個方法還有問題
	@RequestMapping(value = "/StoreOrderListByBuyerIdAndState", method = RequestMethod.GET, produces = {
			"application/json" })
	@ResponseBody
	public List<StoreOrder> getStoreOrderByBuyerIdAndState(StoreOrder storeOrder) throws SQLException {
		return orderService.getStoreOrder(storeOrder);
	}

	// 取得許願資料
	@RequestMapping(value = "/WishList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<Wish> getWishList(Wish wish) throws SQLException {
		return orderService.getWishByM_id(wish);
	}

	// 利用使用者取得許願訂單資料
	@RequestMapping(value = "/WishOrderList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<WishOrder> getWishOrderByBuyerId(Wish wish) throws SQLException {
		return orderService.getWishOrderByBuyerId(wish);
	}

	// 利用許願ID取得許願競標資料
	@RequestMapping(value = "/WishBidList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<WishBid> getWishBidListByW_Id(WishBid wishBid) throws SQLException {
		return orderService.getWishBidListByW_id(wishBid);
	}

	// 利用跟團者ID取得跟團訂單資料
	@RequestMapping(value = "/GroupOrderList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<GroupOrder> getGroupOrderListByM_idOrder(GroupOrder groupOrder) throws SQLException {
		return orderService.getGroupOrderListByM_idOrder(groupOrder);
	}

}
