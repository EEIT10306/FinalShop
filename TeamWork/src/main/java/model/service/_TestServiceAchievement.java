package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.Achievement;
import model.repository.AchievementDao;

@Service
public class _TestServiceAchievement {
	@Autowired
	private AchievementDao achievementDaoImpl;

	public List<Achievement> getSelect(Achievement achievement) {
		try {
			if (achievement.getId() == null) {
				List<Achievement> list = achievementDaoImpl.select();
				return list;
			}
			Achievement temp;
			temp = achievementDaoImpl.select(achievement.getId());
			List<Achievement> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
