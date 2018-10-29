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

import model.bean.CommitAchievement;
import model.service.CommitAchievementPageService;

@Controller
public class AchievementController {
	@Autowired
	private CommitAchievementPageService commitAchievementPageService;
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
	@RequestMapping(value = "/OneUserCommitAchievement", 
			        method = RequestMethod.GET, 
			        produces = { "application/json"})
	@ResponseBody
	public List<CommitAchievement> GetOneUserCommitAchievement(CommitAchievement commitAchievement, BindingResult binder) {
		return commitAchievementPageService.getSelect(commitAchievement);
	}

}
