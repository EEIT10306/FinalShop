package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupReport;

public interface GroupReportDao {
	public List<GroupReport> selectAll() throws SQLException;

	public GroupReport selectByPk(Integer id) throws SQLException;

	public List<GroupReport> selectHql(String hqlString) throws SQLException;

	public GroupReport insert(GroupReport bean) throws SQLException;

	public GroupReport update(GroupReport bean) throws SQLException;

}