package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.GroupOrder;
import model.bean.GroupProduct;
import model.bean.Member;
import model.bean.StoreFavorite;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.service.ShoppingCartService_forGrouponProduct;
import model.service.ShoppingCartService_forStroeProduct;

@Controller
public class ShoppingCartController_forGroupProduct {

	@Autowired
	ShoppingCartService_forGrouponProduct shoppingCartService;

	@RequestMapping(value = "/GetGroupShoppingCartProduct", method = RequestMethod.POST)
	@ResponseBody
	private GroupProduct GetGroupShoppingCartProduct(GroupProduct groupProduct) {
		System.out.println(
				"=====================================Get Group Shopping Cart Product=====================================");
		return shoppingCartService.showGroupProductInformation(groupProduct);
	}

	@RequestMapping(value = "/GetMemberInformation_NewGroupOrder", method = RequestMethod.POST)
	@ResponseBody
	private Member GetMemberInformation(Member member) {
		System.out.println(
				"=====================================Get Member Information=====================================");
		return shoppingCartService.findMemberInformation(member);
	}

	@RequestMapping(value = "/AddNewGroupOrder", method = RequestMethod.POST)
	@ResponseBody
	private void AddNewGroupOrder(GroupOrder groupOrder) {
		System.out.println(
				"=====================================Add New Store Order=====================================");
		shoppingCartService.addNewGroupOrder(groupOrder);
	}

}
