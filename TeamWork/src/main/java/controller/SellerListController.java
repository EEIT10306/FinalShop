package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Member;
import model.bean.StoreProduct;
import model.service.SellerService;

@Controller
public class SellerListController {

	@Autowired
	SellerService sellerService;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	// 用會員ID取得商店上架商品的資料
	@RequestMapping(path = "/StoreProductSellerListByM_id", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<StoreProduct> getStoreProductSellerListByM_id(Member member, BindingResult binder) throws SQLException {
		System.out.println("===================================getStoreProductSellerListByM_id");
		System.out.println("member==================================="+member);
		List<StoreProduct> temps = sellerService.getStoreProductSellerListByM_id(member);
		System.out.println(temps);
		return temps;
	}

}
