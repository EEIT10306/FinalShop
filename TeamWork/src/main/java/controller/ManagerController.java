package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Conversation;
import model.bean.GroupReport;
import model.bean.StoreReport;
import model.bean.WishReport;
import model.service.ConversationService;
import model.service.ReportService;

@Controller
public class ManagerController {
	@Autowired
	private ConversationService CS;
	@Autowired
	private ReportService RS;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
	}

	@RequestMapping(path = "/Manager.getConversation", method = RequestMethod.POST)
	@ResponseBody
	public List<List<Conversation>> getConversation(Conversation conversation, BindingResult binder) {
		System.out.println("in /Manager.getConversation");
		System.out.println("in " + conversation);
		return CS.getConversationTalker(conversation);
	}

	@RequestMapping(path = "/Manager.sendNewConversation", method = RequestMethod.POST)
	@ResponseBody
	public Conversation sendNewConversation(Conversation conversation, BindingResult binder) {
		System.out.println("in /Manager.sendNewConversation");
		System.out.println("in " + conversation);
		if (conversation.getM_idConversation() == null || "".equals(conversation.getC_context())) {
			System.out.println("null");
			return null;
		}
		return CS.insertConversation(conversation);
	}

	@RequestMapping(path = "/Manager.changeConversationRead", method = RequestMethod.POST)
	@ResponseBody
	public Integer changeConversationRead(Conversation conversation, BindingResult binder) {
		System.out.println("in /Manager.changeConversationRead");
		System.out.println("in " + conversation);
		if (conversation.getM_id() == null || conversation.getC_stateId() == null) {
			System.out.println("null");
			return null;
		}
		if (CS.updateConversationState(conversation))
			return 0;
		return null;
	}

	@RequestMapping(path = "/Manager.haveNewMessage", method = RequestMethod.POST)
	@ResponseBody
	public List<List<Conversation>> haveNewMessage() {
		System.out.println("in /Manager.haveNewMessage");
		List<List<Conversation>> beans = CS.getNewMessage();
		if (beans.size() != 0) {
			return beans;
		}
		return null;
	}

	@RequestMapping(path = "/Manager.getReport", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getReport() {
		System.out.println("in /Manager.getReport");
		System.out.println("in ");

		List<List<WishReport>> LLWR = RS.getWishReport();
		List<List<GroupReport>> LLGR = RS.getGroupReport();
		List<List<StoreReport>> LLSR = RS.getStoreReport();
		Map<String, Object> map = new HashMap<>();
		map.put("Wish", LLWR);
		map.put("Group", LLGR);
		map.put("StoreProduct", LLSR);
		return map;
	}
	
	@RequestMapping(path = "/Manager.updateReportState", method = RequestMethod.POST)
	@ResponseBody
	public String updateReportState(WishReport wishReport, GroupReport groupReport, StoreReport storeReport) {
		System.out.println("in /Manager.haveNewMessage");
		System.out.println("in " + wishReport + "and " + groupReport + "and " + storeReport);
		SimpleDateFormat showTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		if(wishReport.getwR_id()!=null) {
		 	WishReport WR = RS.updateWishReport(wishReport);
		 	return showTime.format(WR.getwR_time());
		}else if(groupReport.getgR_id()!=null) {
		 	GroupReport GR = RS.updateGroupReport(groupReport);
		 	return showTime.format(GR.getgR_time());
		}else if(storeReport.getsR_id()!=null) {
			StoreReport SR = RS.updateStoreReport(storeReport);
			return showTime.format(SR.getsR_time());
		}
		return null;
	}
}
