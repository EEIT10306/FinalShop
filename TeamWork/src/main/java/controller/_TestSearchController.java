package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.bean.Product;
import model.bean.StoreProduct;
import model.service.StoreProductService;
import model.service._TestServiceAchievement;
import model.service._TestServiceProduct;
import model.service._TestServiceStoreProduct;
@Controller
public class _TestSearchController {
	@Autowired
	private _TestServiceAchievement tes;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
		
	}
//	@ResponseBody
//	@RequestMapping(path = "/search", method = RequestMethod.GET)
//	public  ResponseEntity<List<Achievement>> TestID  (Achievement achievement, BindingResult binder) {
//		List<Achievement> list = tes.getSelect(achievement);
//		return new ResponseEntity<List<Achievement>>(list, HttpStatus.OK);
//	}
//	@ResponseBody
//	@RequestMapping(path = "/search",method = RequestMethod.POST)      
//	public String filesUpload(@RequestParam ("username")String username,   
//	                         @RequestParam ("password") String password) {      
//	     System.out.println(username + "and" + password);    
//	     return "index";    
//	}   
//	
//	@ResponseBody
//	@RequestMapping(path = "/search",method = RequestMethod.POST)  
//    public void test2(User user){
//        System.out.println(user.getId());
//        System.out.println(user.getUsername());
//        System.out.println(user.getBirthday());
//	}
//	@Autowired
//	private _TestServiceSearch ser;
//	
//	@ResponseBody
//	@RequestMapping(path = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")  
//	public String search(String search) {
//			if(search.equals("wish")) {
//				List<WishProduct> lis =ser.getSelect("selectone");
//			  Gson gson = new Gson();
//			   String json = gson.toJson(lis);
//				//return new JSONArray(lis);
//			   System.out.println(json);
//			   return json ; 
//			}
//		
//			return "" ;
//	}
//	@Autowired
//	private _TestServiceSearch ser;
//	
//	@ResponseBody
//	@RequestMapping(path = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")  
//	public String search(Model model ,String search,String selectone ) {
//				 model.addAttribute("selectone",selectone);
//				 System.out.println(selectone);
//				 System.out.println(search);
//				 
//			   return "testProduct.select" ; 
//			
//		
//			
//	}
	
//	 @RequestMapping(value = "/search")
//	    public ModelAndView toResultViewForNormal(@RequestParam("selectone") String selectone, @RequestParam("search") String search) {
//	        ModelAndView modelAndView = new ModelAndView("web/view/_testProduct-search.html");
//	        modelAndView.addObject("selectone", selectone);
//	        modelAndView.addObject("search", search);
//	        return modelAndView;
//	    }
	 @RequestMapping(path = "/search") 
	 public ModelAndView toResultViewForNormal(String selectone, String search) {
		 System.out.println("進入======================== "+selectone);
		 System.out.println("search= "+search);
		 Map map= new HashMap();
		    map.put("search", search);    
		    
		    ModelAndView modelAndView = new ModelAndView(new RedirectView("web/view/_testProduct-search2.html?"),map);
	  if(selectone.equals("groupon"))
	//   return "redirect:web/view/_testGroupBuying-search.html?search="+search; 
	  return new ModelAndView(new RedirectView("web/view/_testGroupBuying-search.html?"),map) ; 
	  if(selectone.equals("store"))
	//   return  "redirect:web/view/_testProduct-search2.html?search="+search; 
	  return new ModelAndView(new RedirectView("web/view/_testProduct-search2.html?"),map) ; 
	  
	//  return "redirect:web/view/_testWish-search.html?search="+search; 
	  return new ModelAndView(new RedirectView("web/view/_testWish-search.html?"),map) ; 
	 }
	 
	 	@Autowired
		private _TestServiceProduct pro;
	 
		@ResponseBody
		@RequestMapping(path = "/changeStoreFormSelect" ,method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
//		public List<Product> search(Product product) {
			public String search(Product product) {	
				List<Product> lis =pro.getSelect(product);
				System.out.println(lis);
//			   Gson gson = new Gson();
				Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			   String json = gson.toJson(lis);
			   System.out.println(json);   
			  
			   return json;
				//return new JSONArray(lis);
//			   System.out.println(json);
//			   return lis ; 
			
	}
		@Autowired
		private _TestServiceStoreProduct spro;
	 
		@ResponseBody
		@RequestMapping(path = "/StoreProductForm", method = RequestMethod.GET)
		public List<StoreProduct> StoreProductForm(String search) {
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
				System.out.println(search);
				System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
				List<StoreProduct> lis =spro.getStoreProductForm(search);
				
//				System.out.println(lis);
				System.out.println("hahaha");
				return lis;
		}
		@Autowired
		private StoreProductService sps;
	 
		
		
		@ResponseBody
		@RequestMapping(path = "/StoreProductChangeForm", method = RequestMethod.GET)
		public List<StoreProduct> changeLeftProduct(String search,String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m) {
				
				System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
				List<StoreProduct> lis =sps.getStoreProductChangeForm(search,a,b,c,d,e,f,g,h,i,j,k,l,m);	
				System.out.println(lis);
				
				return lis;
		}
		
		
		
}
