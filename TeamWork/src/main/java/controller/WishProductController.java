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
import model.bean.WishBid;
import model.bean.WishCallback;
import model.bean.WishFavorite;
import model.bean.WishImages;
import model.bean.WishMessage;
import model.bean.WishOrder;
import model.bean.WishProduct;
import model.bean.WishReport;
import model.service.DistrictTypeService;
import model.service.MemberService;
import model.service.WishBidService;
import model.service.WishCallbackService;
import model.service.WishFavoriteService;
import model.service.WishMessageService;
import model.service.WishOrderService;
import model.service.WishProductImagesSerivce;
import model.service.WishProductService;
import model.service.WishReportService;
import model.service.WishService;

@Controller
public class WishProductController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private WishFavoriteService wishFavoriteService;
	@Autowired
	private WishBidService wishBidService;
	@Autowired
	private WishProductImagesSerivce wishProductImagesService;
	@Autowired
	private WishService wishService;
	@Autowired
	private DistrictTypeService districtTypeService;
	@Autowired
	private WishProductService wishProductService;
	@Autowired
	private WishReportService wishReportService;
	@Autowired
	private WishMessageService wishMessageService;
	@Autowired
	private WishCallbackService wishCallbackService;
	@Autowired
	private WishOrderService wishOrderService; 
	
	
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
	@RequestMapping(path = "/UpdateOneWish", method = RequestMethod.POST)
	@ResponseBody
	public Wish updateOneWish(Wish bean) throws SQLException {
		return wishService.updateOneWish(bean);
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
	@RequestMapping(path = "/SendWishReport", method = RequestMethod.POST)
	@ResponseBody
	public WishReport sendWishProduct(WishReport bean) throws SQLException {
		return wishReportService.insertOneStoreReport(bean);
	}
	@RequestMapping(path = "/FindOneWishFavoriteBean", method = RequestMethod.POST)
	@ResponseBody
	public List<WishFavorite> getWishFavorite(WishFavorite bean) throws SQLException {
		return wishFavoriteService.getWishFavorite(bean);
	}
	@RequestMapping(path = "/InsertOneWishFavorite", method = RequestMethod.POST)
	@ResponseBody
	public WishFavorite InsertOneWishFavorite(WishFavorite bean) throws SQLException {
		return wishFavoriteService.insertOneWishFavorite(bean);
	}
	@RequestMapping(path = "/DeleteOneWishFavorite", method = RequestMethod.POST)
	@ResponseBody
	public boolean DeleteOneWishFavorite(WishFavorite bean) throws SQLException {
		return wishFavoriteService.deleteWishFavorite(bean);
	}
	@RequestMapping(path = "/FindAllBid", method = RequestMethod.GET)
	@ResponseBody
	public List<WishBid> GetAllBidsByWId(Integer w_id) throws SQLException {
		return wishBidService.selectAllBidByWId(w_id);
	}
	@RequestMapping(path = "/WishMessage", method = RequestMethod.GET)
	@ResponseBody
	public List<WishMessage> GetWishAllMessageByWId(Integer w_id) throws SQLException {
		return wishMessageService.selectAllWishMessageByWId(w_id);
	}
	@RequestMapping(path = "/WishCallback", method = RequestMethod.GET)
	@ResponseBody
	public List<WishCallback> GetWishCallBackAllByWId(Integer w_id) throws SQLException {
		return wishCallbackService.selectAllWishMessageByWId(w_id);
	}
	@RequestMapping(path = "/InsertOneWishMessage", method = RequestMethod.POST)
	@ResponseBody
	public WishMessage InsertOneWishMessage(WishMessage bean) throws SQLException {
		System.out.println(bean);
		return wishMessageService.InsertOneWishMessage(bean);
	}
	@RequestMapping(path = "/InsertOneWishCallback", method = RequestMethod.POST)
	@ResponseBody
	public WishCallback InsertOneWishCallback(WishCallback bean) throws SQLException {
		return wishCallbackService.insertOneWishCallback(bean);
	}
	@RequestMapping(path = "/InsertOneBid", method = RequestMethod.POST)
	@ResponseBody
	public WishBid InsertOneWishBid(WishBid bean) throws SQLException {
		return wishBidService.insertOneWishBid(bean);
	}
	@RequestMapping(path = "/InsertOneWishOrder", method = RequestMethod.POST)
	@ResponseBody
	public WishOrder InsertOneWishOrder(WishOrder bean) throws SQLException {
		return wishOrderService.InsertOneWishOrder(bean);
	}
}
