package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Achievement;
import model.repository.AchievementDao;

@Service
@Transactional
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
			temp = achievementDaoImpl.selectByPk(achievement);
			List<Achievement> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - Achievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
