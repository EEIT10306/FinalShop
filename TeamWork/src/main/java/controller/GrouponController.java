package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.bean.Groupon;
import model.bean.Product;
import model.service.GrouponService;
import model.service.ProductCheageService;
import model.service.StoreProductService;

@Controller
public class GrouponController {
	
	@Autowired
	private GrouponService gro;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));

	}

	@Autowired
	private ProductCheageService pro;

	@ResponseBody
	@RequestMapping(path = "/changeStoreFormSelect1", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//		public List<Product> search(Product product) {
	public String search(Product product) {
		List<Product> lis = pro.getSelect(product);
		System.out.println(lis);
//			   Gson gson = new Gson();
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(lis);
		System.out.println(json);

		return json;
		// return new JSONArray(lis);
//			   System.out.println(json);
//			   return lis ; 

	}

	

	@ResponseBody
	@RequestMapping(path = "/GrouponSearch", method = RequestMethod.GET)
	public List<Groupon> StoreProductForm(String search) {
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
		System.out.println(search);
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
		List<Groupon> lis = gro.getGrouponSearch(search);

//				System.out.println(lis);
		System.out.println("hahaha");
		return lis;
	}

	@Autowired
	private StoreProductService sps;

	@ResponseBody
	@RequestMapping(path = "/GrouponSearchChange", method = RequestMethod.GET)
	public List<Groupon> changeLeftProduct(String search, String a, String b, String c, String d, String e,String f) {

		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
		List<Groupon> lis = gro.getGrouponSearchChange(search, a, b, c, d,e,f);
		System.out.println(lis);

		return lis;
	}

}
