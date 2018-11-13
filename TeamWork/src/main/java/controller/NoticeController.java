package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.StoreOrder;
import model.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(path = "/ReadStoreOrderState", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String ReadStoreOrderState(String account){
		System.out.println("Noticeaccount============"+account);
		Gson gson = new Gson();
		List<StoreOrder> list = noticeService.ReadStoreOrderState(account);
		String json = gson.toJson(list);
		System.out.println("Noticejson = "+json);
		return json;
		
		
	}
}
