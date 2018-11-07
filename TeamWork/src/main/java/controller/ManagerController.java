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

	@RequestMapping(path = "/Manager", method = RequestMethod.POST)
	@ResponseBody
	public List<List<Conversation>> TestID(Conversation conversation, BindingResult binder) {
		System.out.println("in /Manager");
		System.out.println("in " + conversation);
		return CS.getConversationTalker(conversation);
	}

}
