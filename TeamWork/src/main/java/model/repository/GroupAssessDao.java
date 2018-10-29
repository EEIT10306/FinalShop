package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupAssess;

public interface GroupAssessDao {
	public List<GroupAssess> selectAll() throws SQLException;

	public GroupAssess selectByPk(Integer id) throws SQLException;

	public List<GroupAssess> selectHql(String hqlString) throws SQLException;

	public GroupAssess insert(GroupAssess bean) throws SQLException;

	public GroupAssess update(GroupAssess bean) throws SQLException;

}
