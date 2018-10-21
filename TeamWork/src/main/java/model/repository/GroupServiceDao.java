package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupService;

public interface GroupServiceDao {

	public List<GroupService> selectAll() throws SQLException;

	public GroupService select(Integer id) throws SQLException;

	public GroupService insert(GroupService groupService) throws SQLException;

	public GroupService update(Integer id, Integer groupID, String rule, Double off, Integer groupState)
			throws SQLException;

	public Boolean delete(Integer id) throws SQLException;
}
