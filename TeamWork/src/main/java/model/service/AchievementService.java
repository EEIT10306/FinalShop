package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Achievement;
import model.bean.CommitAchievement;
import model.bean.Member;
import model.repository.AchievementDao;
import model.repository.CommitAchievementDao;

@Service
@Transactional
public class AchievementService {
	@Autowired
	private AchievementDao achievementDao;
	@Autowired
	private CommitAchievementDao commitAchievementDao;

	// 取得所有成就任務
	public List<Achievement> getSelect(Achievement achievement) {
		try {
			if (achievement.getA_id() == null) {
				List<Achievement> list = achievementDao.selectAll();
				return list;
			}
			Achievement temp;
			temp = achievementDao.selectByPk(achievement.getA_id());
			List<Achievement> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("AchievementService - Achievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}

	// 取得使用者已達成的成就
	public List<CommitAchievement> getOneUserMedal(CommitAchievement commitAchievement) {
		try {
			if (commitAchievement.getM_id() == null) {
				return commitAchievementDao.selectAll();
			}
			String hql = "WHERE mem_ID = " + commitAchievement.getM_id();
			return commitAchievementDao.selectHql(hql);
		} catch (SQLException e) {
			System.out.println("AchievementService - CommitAchievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}

	// 使用者註冊時新增初始成就任務資料
	public Member insertInitAchievementTask(Member member) throws SQLException {
		Integer m_id = member.getM_id();
		commitAchievementDao.insert(new CommitAchievement(null, 1, m_id, 1, 7));
		commitAchievementDao.insert(new CommitAchievement(null, 2, m_id, 1, 6));
		commitAchievementDao.insert(new CommitAchievement(null, 6, m_id, 0, 6));
		commitAchievementDao.insert(new CommitAchievement(null, 11, m_id, 0, 6));
		commitAchievementDao.insert(new CommitAchievement(null, 16, m_id, 0, 6));
		commitAchievementDao.insert(new CommitAchievement(null, 21, m_id, 0, 6));
		return member;
	}

	// 更改進行中的成就任務狀態
	public void userGetPrice(CommitAchievement commitAchievement) throws SQLException {
		Integer cA_ID = commitAchievement.getcA_id();
		commitAchievementDao.selectByPk(cA_ID).setcA_stateId(8);
		
	}

}
