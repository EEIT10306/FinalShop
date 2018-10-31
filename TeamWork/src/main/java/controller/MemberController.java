package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Member;
import model.service.UserPageService;

@Controller
public class MemberController {
	@Autowired
	private UserPageService userPageService;
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	@RequestMapping(path = "/Member", method = RequestMethod.GET, produces = { "application/json"})
	@ResponseBody
	public Member GetOneUserData(Member member, BindingResult binder) {
		return userPageService.getOneMember(member);
	}
	
	@RequestMapping(path = "/Members", method = RequestMethod.GET, produces = { "application/json"})
	@ResponseBody
	public List<Member> TestID(Member member, BindingResult binder) {
		return userPageService.getSelect(member);
	}
}
