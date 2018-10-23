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

import model.bean.Achievement;
import model.bean.DistrictType;
import model.bean.Group;
import model.bean.Wish;
import model.bean.WishMessage;
import model.bean.WishProduct;
import model.service._TestServiceAchievement;
import model.service._TestServiceDistrictType;
import model.service._TestServiceGroup;
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
	private _TestServiceGroup tes5;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	@RequestMapping(path = "/Achievement", method = RequestMethod.GET)
	public ResponseEntity<List<Achievement>> TestID(Achievement achievement, BindingResult binder) {
		List<Achievement> list = tes.getSelect(achievement);
		return new ResponseEntity<List<Achievement>>(list, HttpStatus.OK);
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
	public ResponseEntity<List<DistrictType>> TestID(DistrictType districtType, BindingResult binder) {
		List<DistrictType> list = tes4.getSelect(districtType);
		return new ResponseEntity<List<DistrictType>>(list, HttpStatus.OK);
	}
	@RequestMapping(path = "/Group", method = RequestMethod.GET)
	public ResponseEntity<List<Group>> TestID(Group group, BindingResult binder) {
		List<Group> list = tes5.getSelect(group);
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
	}
	
}
