package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Achievement;

public interface AchievementDao {
	public List<Achievement> selectAll() throws SQLException;

	public Achievement selectByPk(Integer id) throws SQLException;

	public List<Achievement> selectHql(String hqlString) throws SQLException;

	public Achievement insert(Achievement bean) throws SQLException;

	public Achievement update(Achievement bean) throws SQLException;

}
