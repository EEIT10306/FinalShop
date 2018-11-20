package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.XYAnalytics;

public interface XYAnalyticsDao {
	public List<XYAnalytics> selectAll() throws SQLException;

	public XYAnalytics selectByPk(Integer id) throws SQLException;

	public List<XYAnalytics> selectHql(String hqlString) throws SQLException;

	public XYAnalytics insert(XYAnalytics bean) throws SQLException;

	public XYAnalytics update(XYAnalytics bean) throws SQLException;

	public XYAnalytics update(XYAnalytics A, XYAnalytics bean) throws SQLException;
}
