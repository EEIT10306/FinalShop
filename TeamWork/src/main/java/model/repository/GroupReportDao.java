package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupReport;

public interface GroupReportDao {
	List<GroupReport> select() throws SQLException;
	GroupReport select(Integer id) throws SQLException;
	GroupReport insert(GroupReport bean) throws SQLException;
	GroupReport update(Integer id, String content) throws SQLException;
	boolean delete(Integer id) throws SQLException;
}