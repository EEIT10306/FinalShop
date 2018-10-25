package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupReport;

public interface GroupReportDao {
	public List<GroupReport> select() throws SQLException;
	public GroupReport selectByPk(GroupReport bean) throws SQLException;
	public GroupReport insert(GroupReport bean) throws SQLException;
	public GroupReport update(GroupReport bean) throws SQLException;
	
}