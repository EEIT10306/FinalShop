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

import model.bean.Achievement;
import model.bean.CommitAchievement;
import model.service.AchievementService;

@Controller
public class AchievementController {
	@Autowired
	private AchievementService achievementService;
	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
	//查詢所有成就任務
	@RequestMapping(value = "/AllAchievement", 
			        method = RequestMethod.GET, 
			        produces = { "application/json"})
	@ResponseBody
	public List<Achievement> AllAchievements(Achievement achievement) {
		return achievementService.getSelect(achievement);
	}

	//以M_id查詢已完成的成就
	@RequestMapping(value = "/UserMedal", 
	        method = RequestMethod.GET, 
	        produces = { "application/json"})
	@ResponseBody
	public List<CommitAchievement> getOneUserMedal(CommitAchievement commitAchievement) {
		return achievementService.getOneUserMedal(commitAchievement);
	}
	
	//傳入cA_id
	//1.更改成就狀態為8(領取獎品)
	//2.Member獎金更新
	@RequestMapping(value = "/userGetPrice", method = RequestMethod.GET )
	public void userGetPrice(CommitAchievement commitAchievement) throws SQLException {
		achievementService.userGetPrice(commitAchievement);
	}
	
}
