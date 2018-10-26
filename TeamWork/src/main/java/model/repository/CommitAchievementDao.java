package model.repository;


import java.sql.SQLException;
import java.util.List;

import model.bean.CommitAchievement;

public interface CommitAchievementDao {
	public List<CommitAchievement> select() throws SQLException;
	public CommitAchievement selectByPk(Integer id) throws SQLException;
	public CommitAchievement insert(CommitAchievement bean) throws SQLException;
	public CommitAchievement update(CommitAchievement bean) throws SQLException;
}