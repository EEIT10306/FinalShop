package model.repository;


import java.sql.SQLException;
import java.util.List;

import model.bean.Achievement;

public interface AchievementDao {
	public List<Achievement> select() throws SQLException;
	public Achievement select(Integer id) throws SQLException;
	public Achievement insert(Achievement bean) throws SQLException;
	public Achievement update(Integer id, String context, Integer bonus, Integer parentsId) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
