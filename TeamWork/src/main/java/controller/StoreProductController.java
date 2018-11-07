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

import model.bean.StoreAssess;
import model.bean.StoreCallback;
import model.bean.StoreMessage;
import model.bean.StoreProduct;
import model.bean.StoreReport;
import model.service.StoreAssessService;
import model.service.StoreCallbackService;
import model.service.StoreMessageService;
import model.service.StoreProductService;
import model.service.StoreReportService;

@Controller
public class StoreProductController {
	@Autowired
	private StoreProductService storeProductService;
	@Autowired
	private StoreAssessService storeAssessService;
	@Autowired
	private StoreMessageService storeMessageService;
	@Autowired
	private StoreCallbackService storeCallbackService;
	@Autowired
	private StoreReportService storeReportService;
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
	@RequestMapping(path = "/StoreProduct", method = RequestMethod.GET)
	@ResponseBody
	public StoreProduct GetOneStoreProduct(Integer sP_id) throws SQLException {
		return storeProductService.selectByPk(sP_id);	
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
	public StoreReport InsertOneStoreReport(StoreReport bean) throws SQLException{
		return storeReportService.insertOneReportBySpId(bean);
	}

}
