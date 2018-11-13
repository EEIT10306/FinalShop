package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Member;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.service.ShoppingCartService_forStroeProduct;

@Controller
public class ShoppingCartController_forStroeProduct {

	@Autowired
	ShoppingCartService_forStroeProduct shoppingCartService;

	@RequestMapping(value = "/GetShoppingCartProduct", method = RequestMethod.POST)
	@ResponseBody
	private StoreProduct GetShoppingCartProduct(StoreProduct storeProduct) {
		System.out.println(
				"=====================================Get Shopping Cart Product=====================================");
		return shoppingCartService.showStoreProductInformation(storeProduct);
	}

	@RequestMapping(value = "/GetMemberInformation", method = RequestMethod.POST)
	@ResponseBody
	private Member GetMemberInformation(Member member) {
		System.out.println(
				"=====================================Get Member Information=====================================");
		return shoppingCartService.findMemberInformation(member);
	}

	@RequestMapping(value = "/AddNewStoreOrder", method = RequestMethod.POST)
	@ResponseBody
	private void AddNewStoreOrder(StoreOrder storeOrder) {
		System.out.println(
				"=====================================Add New Store Order=====================================");
		shoppingCartService.addNewStoreOrder(storeOrder);
	}

}
