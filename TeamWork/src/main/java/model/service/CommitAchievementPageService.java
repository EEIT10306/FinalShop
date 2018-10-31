package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CommitAchievement;
import model.repository.CommitAchievementDao;

@Service
@Transactional
public class CommitAchievementPageService {
	@Autowired
	private CommitAchievementDao commitAchievementImpl;
	
	public List<CommitAchievement> getSelect(CommitAchievement commitAchievement) {
		try {
			if (commitAchievement.getcA_id() == null) {
				List<CommitAchievement> list = commitAchievementImpl.selectAll();
				return list;
			}
			CommitAchievement temp;
			temp = commitAchievementImpl.selectByPk(commitAchievement.getcA_id());
			List<CommitAchievement> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("CommitAchievementPageService - CommitAchievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
