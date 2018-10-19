package model.repository.dao;


import java.sql.SQLException;
import java.util.List;

import model.bean.CommitAchievement;

public interface CommitAchievementDao {
	public List<CommitAchievement> select() throws SQLException;
	public CommitAchievement select(Integer id) throws SQLException;
	public CommitAchievement insert(CommitAchievement bean) throws SQLException;
	public CommitAchievement update(Integer id, Integer achievementId, Integer memberId) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
