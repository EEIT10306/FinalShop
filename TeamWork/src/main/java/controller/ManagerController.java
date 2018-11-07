package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import model.service.ConversationService;

@Controller
public class ManagerController {
	@Autowired
	private ConversationService CS;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
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
		if(conversation.getM_idConversation() ==null || "".equals(conversation.getC_context())) {
			System.out.println("null");
			return null;
		}		
		return CS.insertConversation(conversation);
	}

}
