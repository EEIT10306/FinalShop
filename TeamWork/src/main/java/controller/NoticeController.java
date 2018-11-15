package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.GroupOrder;
import model.bean.StoreOrder;
import model.bean.WishOrder;
import model.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(path = "/ReadStoreOrderState", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String ReadStoreOrderState(String account){
		System.out.println("StoreNoticeaccount============"+account);
		Gson gson = new Gson();
		List<StoreOrder> list = noticeService.ReadStoreOrderState(account);
		String json = gson.toJson(list);
		System.out.println("Noticejson = "+json);
		return json;
	}
	
	@RequestMapping(path = "/ReadWishOrderState", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String ReadWishOrderState(String account){
		System.out.println("WishNoticeaccount============"+account);
		Gson gson = new Gson();
		List<WishOrder> list = noticeService.ReadWishOrderState(account);
		String json = gson.toJson(list);
		System.out.println("WishNoticejson = "+json);
		return json;
	}
	
	@RequestMapping(path = "/ReadGroupOrderState", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String ReadGroupOrderState(String account){
		System.out.println("GroupNoticeaccount============"+account);
		Gson gson = new Gson();
		List<GroupOrder> list = noticeService.ReadGroupOrderState(account);
		String json = gson.toJson(list);
		System.out.println("GroupNoticejson = "+json);
		return json;
	}
}
