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
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.StoreProduct;
import model.service.StoreProductService;

@Controller
public class StoreProductController {
	@Autowired
	private StoreProductService productDetailService;
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
//	@RequestMapping(path = "/StoreProduct", method = RequestMethod.GET, produces = { "application/json"})
//	@ResponseBody
//	public StoreProduct GetOneStoreProduct(Integer id, BindingResult binder) throws SQLException {
//		return productDetailService.selectByPk(id);		
//	}
	@RequestMapping(path = "/StoreProduct", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseBody
	public StoreProduct GetOneStoreProduct(Integer sP_id) throws SQLException {
		System.out.println(sP_id);
		return productDetailService.selectByPk(sP_id);		
	}
}
