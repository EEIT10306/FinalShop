package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.GroupProduct;
import model.bean.StoreProduct;
import model.bean.WishProduct;
import model.service.GroupProductService;
import model.service.StoreProductService;
import model.service.WishProductService;

@Controller
public class AddProduct {
	
	@Autowired
	StoreProductService storeProductService;
	@Autowired
	GroupProductService groupProductService;
	@Autowired
	WishProductService wishProductService;
	
	@RequestMapping(value = "/AddStoreProduct" , method = RequestMethod.POST)
	@ResponseBody
	private String AddStoreProduct(StoreProduct storeProduct) {
		Gson gson = new Gson();
		System.out.println(storeProduct.toString());
		System.out.println("AddStoreProduct");
		storeProduct.setS_id(1);
		storeProduct.setsP_hot(5);
		storeProduct.setsP_amountFavorite(4);
		storeProduct.setsP_time(new Date());
		storeProduct.setsP_averageAssess(2.0);
		storeProduct.setsP_amountAssess(1);
		storeProduct.setsP_stateId(13);
		StoreProduct list = storeProductService.insert(storeProduct);
		String json = gson.toJson(list);
		
		System.out.println("json = " + json);
		return json;
		
	}
	
	@RequestMapping(value = "/AddGroupon" , method = RequestMethod.POST)
	@ResponseBody
	private String AddGroupon(GroupProduct groupProduct) {
		Gson gson = new Gson();
		groupProduct.setG_iD(5);
		groupProduct.setgP_stateId(53);
		GroupProduct list = groupProductService.insert(groupProduct);
		System.out.println(list);
		return null;
		
		
	}
	
	@RequestMapping(value = "/AddWish" , method = RequestMethod.POST)
	@ResponseBody
	private String AddWish(WishProduct wishProduct) {
		Gson gson = new Gson();
		wishProduct.setW_id(5);
		wishProduct.setwP_stateId(32);
		WishProduct list = wishProductService.insert(wishProduct);
		System.out.println(list);
		return null;
		
		
	}
}
