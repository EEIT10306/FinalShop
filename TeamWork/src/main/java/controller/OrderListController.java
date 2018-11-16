package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.bean.GroupAssess;
import model.bean.GroupOrder;
import model.bean.Member;
import model.bean.StoreAssess;
import model.bean.StoreOrder;
import model.bean.Wish;
import model.bean.WishAssess;
import model.bean.WishBid;
import model.bean.WishOrder;
import model.service.OrderService;
import model.service.UserPageImageService;

@Controller
public class OrderListController {

	@Autowired
	OrderService orderService;
	@Autowired
	UserPageImageService userPageImageService;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
	// 更新使用者資料
	@RequestMapping(value = "/EditMyAccountData", method = RequestMethod.POST)
	public String editAccountData(Member member, BindingResult binder) throws SQLException {
		System.out.println(member);
		orderService.editAccountData(member);
		return "redirect:/web/view/userPage_profile.html";
	}
	
	//更新使用者圖像
	@RequestMapping(value = "/UpdateAccountImage", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String updateAccountImage(List<MultipartFile> files,Integer m_id) {
		System.out.println("UpdateAccountImage-files:==========="+files);
		System.out.println("m_id:==========="+m_id);
		//執行上傳圖片方法
		for(MultipartFile file : files) {			
			userPageImageService.insertAccountImage(file, m_id);
		}
		return "updateAccountImage Success!";
	}
	
	// 取得商店訂單資料
	@RequestMapping(value = "/StoreOrderList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<StoreOrder> getStoreOrderList(StoreOrder storeOrder) throws SQLException {
		return orderService.getStoreOrder(storeOrder);
	}

	// 利用會員ID取得許願資料
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

	// 新增一筆跟團評價資料(買的人評)
	@RequestMapping(path = "/giveAssess.do", method = RequestMethod.POST)
	public String giveAssess(GroupAssess groupAssess, BindingResult binder) throws SQLException {
		orderService.giveAssess_GroupBuyer(groupAssess);
		return "redirect:/web/view/userPage_GroupOrderList.html";
	}

	// 將開團訂單的狀態由待收貨轉為完成
	@RequestMapping(path = "/confirmReceive_Group", method = RequestMethod.POST)
	public String confirmReceive_Group(GroupOrder groupOrder, BindingResult binder) throws SQLException {
		orderService.confirmReceive_Group(groupOrder);
		return "redirect:/web/view/userPage_GroupOrderList.html";
	}

	// 將商店訂單的狀態由待收貨轉為完成
	@RequestMapping(path = "/confirmReceive_Store", method = RequestMethod.POST)
	public String confirmReceive_Store(StoreOrder storeOrder, BindingResult binder) throws SQLException {
		orderService.confirmReceive_Store(storeOrder);
		return "redirect:/web/view/userPage_StoreOrderList.html";
	}

	// 新增一筆跟團評價資料(買的人評)
	@RequestMapping(path = "/giveAssess_StoreBuyer", method = RequestMethod.POST)
	public String giveAssess_StoreBuyer(StoreAssess storeAssess, BindingResult binder) throws SQLException {
		orderService.giveAssess_StoreBuyer(storeAssess);
		return "redirect:/web/view/userPage_StoreOrderList.html";
	}

	// 新增一筆許願訂單評價資料(買的人評)
	@RequestMapping(path = "/giveAssess_WishBuyer", method = RequestMethod.POST)
	public String giveAssess_WishBuyer(WishAssess wishAssess, BindingResult binder) throws SQLException {
		orderService.giveAssess_WishBuyer(wishAssess);
		return "redirect:/web/view/userPage_WishOrderList.html";
	}

	// 將願望訂單的狀態由待收貨轉為完成
	@RequestMapping(path = "/confirmReceive_Wish", method = RequestMethod.POST)
	public String confirmReceive_Wish(WishOrder wishOrder, BindingResult binder) throws SQLException {
		orderService.confirmReceive_Wish(wishOrder);
		return "redirect:/web/view/userPage_WishOrderList.html";
	}

}
