package controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.Seller;
import model.bean.Store;
import model.service.SellerVerifyService;

@Controller
public class SellerVerifyController {

	@Autowired
	SellerVerifyService sellerVerifyService;

	@InitBinder
	protected void InitBinder(WebDataBinder binder,WebDataBinder binder2) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
		binder2.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	@RequestMapping(path = "/sellerVerify.do", method = RequestMethod.POST)
	public String sellerVerify(Store store,BindingResult binder, Seller seller, BindingResult binder2)
			throws SQLException {
		System.out.println(store);
		System.out.println(seller);
		// 接收資料
		sellerVerifyService.VerifySellerData(store,seller);
		return "redirect:/web/view/userPage_sellerVerify.html";
	}

}
