package controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Achievement;
import model.bean.DistrictType;
import model.bean.Groupon;
import model.bean.Member;
import model.bean.Wish;
import model.bean.WishMessage;
import model.bean.WishProduct;
import model.service.UserPageService;
import model.service._TestServiceAchievement;
import model.service._TestServiceDistrictType;
import model.service._TestServiceGroupon;
import model.service._TestServiceWish;
import model.service._TestServiceWishMessage;
import model.service._TestServiceWishProduct;

@Controller
public class _TestController {
	@Autowired
	private _TestServiceAchievement tes;
	@Autowired
	private _TestServiceWish tes1;
	@Autowired
	private _TestServiceWishProduct tes2;
	@Autowired
	private _TestServiceWishMessage tes3;
	@Autowired
	private _TestServiceDistrictType tes4;
	@Autowired
	private _TestServiceGroupon tes5;
	@Autowired
	private _TestServiceAchievement memtes;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	@RequestMapping(path = "/Achievement", method = RequestMethod.GET)
	@ResponseBody
	public List<Achievement> TestID(Achievement achievement, BindingResult binder) {
		return tes.getSelect(achievement);
	}
	
	@RequestMapping(path = "/Wish", method = RequestMethod.GET)
	public ResponseEntity<List<Wish>> TestID(Wish wish, BindingResult binder) {
		List<Wish> list = tes1.getSelect(wish);
		return new ResponseEntity<List<Wish>>(list, HttpStatus.OK);
	}
	@RequestMapping(path = "/WishProduct", method = RequestMethod.GET)
	public ResponseEntity<List<WishProduct>> TestID(WishProduct wishProduct, BindingResult binder) {
		List<WishProduct> list = tes2.getSelect(wishProduct);
		return new ResponseEntity<List<WishProduct>>(list, HttpStatus.OK);
	}
	@RequestMapping(path = "/WishMessage", method = RequestMethod.GET)
	public ResponseEntity<List<WishMessage>> TestID(WishMessage wishMessage, BindingResult binder) {
		List<WishMessage> list = tes3.getSelect(wishMessage);
		return new ResponseEntity<List<WishMessage>>(list, HttpStatus.OK);
	}
	@RequestMapping(path = "/DistrictType", method = RequestMethod.GET)
	@ResponseBody
	public List<DistrictType> TestID(DistrictType districtType, BindingResult binder) {
		return tes4.getSelect(districtType);
	}
	@RequestMapping(path = "/Groupon", method = RequestMethod.GET)
	public ResponseEntity<List<Groupon>> TestID(Groupon groupon, BindingResult binder) {
		List<Groupon> list = tes5.getSelect(groupon);
		return new ResponseEntity<List<Groupon>>(list, HttpStatus.OK);
	}
	
	
}
