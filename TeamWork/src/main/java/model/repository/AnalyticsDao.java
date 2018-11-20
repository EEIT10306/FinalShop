package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Analytics;

public interface AnalyticsDao {
	public List<Analytics> selectAll() throws SQLException;

	public Analytics selectByPk(Integer id) throws SQLException;

	public List<Analytics> selectHql(String hqlString) throws SQLException;

	public Analytics insert(Analytics bean) throws SQLException;

	public Analytics update(Analytics bean) throws SQLException;

	public Analytics update(Analytics A, Analytics bean) throws SQLException;
}
