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

import model.bean.Member;
import model.bean.StoreAssess;
import model.bean.StoreCallback;
import model.bean.StoreFavorite;
import model.bean.StoreImages;
import model.bean.StoreMessage;
import model.bean.StoreProduct;
import model.bean.StoreReport;
import model.service.MemberService;
import model.service.StoreAssessService;
import model.service.StoreCallbackService;
import model.service.StoreFavoriteService;
import model.service.StoreImagesService;
import model.service.StoreMessageService;
import model.service.StoreProductService;
import model.service.StoreReportService;

@Controller
public class StoreProductController {
	@Autowired
	private StoreProductService storeProductService;
	@Autowired
	private StoreImagesService storeImagesService;
	@Autowired
	private StoreAssessService storeAssessService;
	@Autowired
	private StoreMessageService storeMessageService;
	@Autowired
	private StoreCallbackService storeCallbackService;
	@Autowired
	private StoreReportService storeReportService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private StoreFavoriteService storeFavoriteService;
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
	@RequestMapping(path = "/StoreProduct", method = RequestMethod.GET)
	@ResponseBody
	public StoreProduct GetOneStoreProduct(Integer sP_id) throws SQLException {
		return storeProductService.selectByPk(sP_id);	
	}
	@RequestMapping(path = "/StoreProductPhotos", method = RequestMethod.GET)
	@ResponseBody
	public List<StoreImages> GetStoreProductPhotos(Integer sP_id) throws SQLException {
		return storeImagesService.selectBySp_Id(sP_id);	
	}
	@RequestMapping(path = "/StoreAssess", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseBody
	public List<StoreAssess> GetStoreProductAllAssess(Integer sP_id) throws SQLException {
		return storeAssessService.selectAllAssessBySpId(sP_id);
	}
	@RequestMapping(path = "/StoreMessage", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseBody
	public List<StoreMessage> GetStoreProductAllMessageBySpId(Integer sP_id) throws SQLException{
		return storeMessageService.selectAllStoreMessageBySpId(sP_id);
	}
	@RequestMapping(path = "/StoreCallback", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseBody
	public List<StoreCallback> GetStoreProductAllMessage(Integer sP_id) throws SQLException{
		return storeCallbackService.selectAllStoreCallbackBySpId(sP_id);
	}
	@RequestMapping(path = "/SendStoreReport", method = RequestMethod.POST)
	@ResponseBody
	public StoreReport InsertOneStoreReport(StoreReport bean) throws SQLException{
		return storeReportService.insertOneReportBySpId(bean);
	}
	@RequestMapping(path = "/FindMemberById", method = RequestMethod.POST, produces = {"application/json"})
	@ResponseBody
	public Member emailToMember(String email) throws SQLException {
		return memberService.emailToMember(email);
	}
	@RequestMapping(path = "/InsertOneStoreMessage", method = RequestMethod.POST)
	@ResponseBody
	public StoreMessage InsertOneStoreMessage(StoreMessage bean) throws SQLException{
		return storeMessageService.insert(bean);
	}
	@RequestMapping(path = "/DeleteOneStoreMessage", method = RequestMethod.POST)
	@ResponseBody
	public StoreMessage DeleteOneStoreMessage(StoreMessage bean) throws SQLException {
		return storeMessageService.delete(bean);
	}
	@RequestMapping(path = "/UpdateOneStoreMessage", method = RequestMethod.POST)
	@ResponseBody
	public StoreMessage UpdateOneStoreMessage(StoreMessage bean) throws SQLException {
		return storeMessageService.update(bean);
	}
	@RequestMapping(path = "/InsertOneStoreCallback", method = RequestMethod.POST)
	@ResponseBody
	public StoreCallback InsertOneStoreCallback(StoreCallback bean) throws SQLException {
		return storeCallbackService.insertOneStoreCallback(bean);
	}
	@RequestMapping(path = "/checkStoreProductFavorite", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkStoreProductFavorite(StoreFavorite bean) throws SQLException {
		List<StoreFavorite> list = storeFavoriteService.checkStoreProductFavorite(bean);
		return list.isEmpty();
	}
	@RequestMapping(path = "/FindOneStoreProductFavoriteBean", method = RequestMethod.POST)
	@ResponseBody
	public List<StoreFavorite> findOneStoreFavorite(StoreFavorite bean) throws SQLException {
		return storeFavoriteService.checkStoreProductFavorite(bean);
	}
	@RequestMapping(path = "/InsertOneStoreProductFavorite", method = RequestMethod.POST)
	@ResponseBody
	public StoreFavorite insertOneStoreFavorite(StoreFavorite bean) throws SQLException {
		return storeFavoriteService.insertOneStoreFavorite(bean);
	}
	@RequestMapping(path = "/DeleteOneStoreProductFavorite", method = RequestMethod.POST)
	@ResponseBody
	public boolean DeleteOneStoreFavorite(StoreFavorite bean) throws SQLException {
		return storeFavoriteService.deleteOneStoreFavorite(bean);
	}
}
