package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import model.bean.Achievement;
import model.bean.WishProduct;
import model.service._TestServiceAchievement;
import model.service._TestServiceSearch;
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
	@Autowired
	private _TestServiceSearch ser;
	
	@ResponseBody
	@RequestMapping(path = "/search",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")  
	public String search(String search,String selectone) {
			if(search.equals("wish")) {
				List<WishProduct> lis =ser.getSelect("selectone");
			  Gson gson = new Gson();
			   String json = gson.toJson(lis);
				//return new JSONArray(lis);
			   System.out.println(json);
			   return json ; 
			}
		
			return "" ;
	}
	
	
}
