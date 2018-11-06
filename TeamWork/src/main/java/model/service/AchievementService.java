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
import model.repository.MemberDao;

@Service
@Transactional
public class AchievementService {
	@Autowired
	private AchievementDao achievementDao;
	@Autowired
	private CommitAchievementDao commitAchievementDao;
	@Autowired
	private MemberDao memberDao;

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

	// 領取成就獎勵
	public void claimPrize(CommitAchievement commitAchievement) throws SQLException {
		//會員ID
		Integer cA_id = commitAchievement.getcA_id();
		//用會員ID取得該筆完整資料
		CommitAchievement cA_bean = commitAchievementDao.selectByPk(cA_id);
		//更改成就狀態
		cA_bean.setcA_stateId(8);
		commitAchievementDao.update(cA_bean);
		
		//取得該成就獎賞資訊
		Integer a_id = cA_bean.getA_id();
		Achievement a_temp = achievementDao.selectByPk(a_id);
		Integer bounce = a_temp.getA_bonus();
		
		//會員ID，增加該會員金幣
		Member m_bean = memberDao.selectByPk(cA_bean.getM_id());
		m_bean.setM_coin(m_bean.getM_coin()+bounce);

	}

}
