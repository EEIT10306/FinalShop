package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.StoreProduct;
import model.service.StoreProductService;

@Controller
public class AddProduct {
	
	@Autowired
	StoreProductService storeProductService;
	
	@RequestMapping(value = "/AddStoreProduct" , method = RequestMethod.POST)
	@ResponseBody
	private String AddStoreProduct(StoreProduct storeProduct) {
		
		System.out.println(storeProduct.toString());
		System.out.println("AddStoreProduct");
		storeProduct.setS_id(1);
		storeProduct.setsP_hot(5);
		storeProduct.setsP_amountFavorite(4);
		storeProduct.setsP_time(new Date());
		storeProduct.setsP_averageAssess(2.0);
		storeProduct.setsP_amountAssess(1);
		storeProduct.setsP_stateId(13);
		storeProductService.insert(storeProduct);
		System.out.println(storeProduct);
		return storeProduct.getsP_transport();
		
	}
}
