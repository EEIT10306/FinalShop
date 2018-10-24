package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupService;

public interface GroupServiceDao {

	public List<GroupService> selectAll() throws SQLException;

	public GroupService selectByPk(GroupService groupServiceBean) throws SQLException;

	public GroupService insert(GroupService groupServiceBean) throws SQLException;

	public GroupService update(GroupService groupServiceBean) throws SQLException;
}
