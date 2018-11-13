package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.DistrictType;
import model.bean.Member;
import model.bean.Wish;
import model.bean.WishFavorite;
import model.bean.WishImages;
import model.bean.WishProduct;
import model.service.DistrictTypeService;
import model.service.MemberService;
import model.service.WishFavoriteService;
import model.service.WishProductImagesSerivce;
import model.service.WishProductService;
import model.service.WishService;

@Controller
public class WishProductController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private WishFavoriteService wishFavoriteService;
	@Autowired
	private WishProductImagesSerivce wishProductImagesService;
	@Autowired
	private WishService wishService;
	@Autowired
	private DistrictTypeService districtTypeService;
	@Autowired
	private WishProductService wishProductService;
	@RequestMapping(path = "/FindMemberByEmail", method = RequestMethod.POST, produces = {"application/json"})
	@ResponseBody
	public Member emailToMember(String email) throws SQLException {
		return memberService.emailToMember(email);
	}
	@RequestMapping(path = "/CheckWishFavorite",method = RequestMethod.POST)
	@ResponseBody
	public boolean checkWishFavorite(WishFavorite bean) throws SQLException {
		return wishFavoriteService.checkWishProductFavorite(bean);
	}
	@RequestMapping(path = "/FindWishImagesByWPBean",method = RequestMethod.POST)
	@ResponseBody
	public List<WishImages> findWishImagesByWishProductBean(WishProduct bean) throws SQLException{
		return wishProductImagesService.FindImagesByWishProductBean(bean);
	}
	@RequestMapping(path = "/FindOneWish", method = RequestMethod.GET)
	@ResponseBody
	public Wish findOneWish(Integer w_id) throws SQLException {
		return wishService.findOneWishByWId(w_id);
	}
	@RequestMapping(path = "/FindOneWishDistrictType",method = RequestMethod.POST)
	@ResponseBody
	public DistrictType getWishDistrictType(Integer d_id) throws SQLException {
		return districtTypeService.findOneDistrictTypeByDId(d_id);
	}
	@RequestMapping(path = "/GetWishProducts", method = RequestMethod.POST)
	@ResponseBody
	public List<WishProduct> getWishProduct(WishProduct bean) throws SQLException {
		return wishProductService.selectWishProductsByWBean(bean);
	}
}
