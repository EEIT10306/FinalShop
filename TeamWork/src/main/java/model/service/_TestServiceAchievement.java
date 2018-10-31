package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Achievement;
import model.bean.Member;
import model.repository.AchievementDao;
import model.repository.MemberDao;

@Service
@Transactional
public class _TestServiceAchievement {
	@Autowired
	private AchievementDao achievementDaoImpl;
	@Autowired
	private MemberDao memberDaoImpl;

	public List<Achievement> getSelect(Achievement achievement) {
		try {
			if (achievement.getId() == null) {
				List<Achievement> list = achievementDaoImpl.selectAll();
				return list;
			}
			Achievement temp;
			temp = achievementDaoImpl.selectByPk(achievement.getId());
			List<Achievement> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - Achievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}
	public Member getInsert(Member member) throws SQLException {
		return memberDaoImpl.insert(member);
	}
}
