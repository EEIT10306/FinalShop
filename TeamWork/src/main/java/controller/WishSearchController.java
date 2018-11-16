package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.StoreProduct;
import model.bean.Wish;
import model.bean.WishBid;
import model.service.WishBidService;
import model.service.WishSearchService;

//@Controller
public class WishSearchController {
	
	@Autowired
	private WishBidService wbid; 
	
	@Autowired
	private WishSearchService wishSearch;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));

	}

//	@Autowired
//	private _TestServiceProduct pro;
//
//	@ResponseBody
//	@RequestMapping(path = "/changeStoreFormSelect1", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
////		public List<Product> search(Product product) {
//	public String search(Product product) {
//		List<Product> lis = pro.getSelect(product);
//		System.out.println(lis);
////			   Gson gson = new Gson();
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		String json = gson.toJson(lis);
//		System.out.println(json);
//
//		return json;
		// return new JSONArray(lis);
//			   System.out.println(json);
//			   return lis ; 

//	}

//	@Autowired
//	private _TestServiceStoreProduct spro;
//
//	@ResponseBody
//	@RequestMapping(path = "/StoreProductForm1fdsfs", method = RequestMethod.GET)
//	public List<StoreProduct> StoreProductForm(String search) {
//		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
//		System.out.println(search);
//		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
//		List<StoreProduct> lis = spro.getStoreProductForm(search);
//
////				System.out.println(lis);
//		System.out.println("hahaha");
//		return lis;
//	}
	@ResponseBody
	@RequestMapping(path = "/WishLoad", method = RequestMethod.GET, produces = { "application/json" })
	public List<Wish> WishLoad(String search) throws SQLException {
		System.out.println("controller"+search);
		List<Wish> lis = wishSearch.getWishLoadList(search);
		System.out.println("wwwwwwwwwwwww");
		System.out.println(lis);
		return lis;
	}
	

	@ResponseBody
	@RequestMapping(path = "/WishBidLists", method = RequestMethod.GET, produces = { "application/json" })
	public List<WishBid> WishBidList(Wish wish) throws SQLException {
		System.out.println("WishBidList");
		return wishSearch.getWishBidListByW_id(wish);
	}
	
	@ResponseBody
	@RequestMapping(path = "/WishForm", method = RequestMethod.GET, produces = { "application/json" })
	public List<WishBid> WishForm(String search) throws SQLException {
		System.out.println("controller"+search);
		List<WishBid> lis = wbid.getWishForm(search);
		System.out.println("wwwwwwwwwwwww");
		System.out.println(lis);
		return lis;
	}

	@ResponseBody
	@RequestMapping(path = "/WishCheage", method = RequestMethod.GET)
	public List<Wish> WishCheage(String search,String a,String b,String c,String d,String e,String f) {
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
			System.out.println("e="+e);
			System.out.println("f="+f);
			List<Wish> lis =wishSearch.getWishCheage(search, a, b, c, d, e, f);
			return lis;
	}
	
	@ResponseBody
	@RequestMapping(path = "/WishHot", method = RequestMethod.GET)
	public void WishHot(Wish wish) {
			System.out.println("========================================================================");
			try {
				Wish lis =wishSearch.getWishHot(wish);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
}
