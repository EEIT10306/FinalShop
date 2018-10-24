package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupAssess;

public interface GroupAssessDao {

	public List<GroupAssess> selectAll() throws SQLException;

	public GroupAssess selectByPk(GroupAssess groupAssessBean) throws SQLException;

	public GroupAssess insert(GroupAssess groupAssessBean) throws SQLException;

	public GroupAssess update(GroupAssess groupAssessBean) throws SQLException;
}
