package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.Achievement;
import model.service._TestServiceAchievement;

@Controller
public class _TestController {
	@Autowired
	private _TestServiceAchievement tes;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	@RequestMapping(path = "/Achievement", method = RequestMethod.GET)
	public ResponseEntity<List<Achievement>> TestID(Achievement achievement, BindingResult binder) {
		List<Achievement> list = tes.getSelect(achievement);
		return new ResponseEntity<List<Achievement>>(list, HttpStatus.OK);
	}
}
