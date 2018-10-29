package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupCallback;

public interface GroupCallbackDao {
	public List<GroupCallback> selectAll() throws SQLException;

	public GroupCallback selectByPk(Integer id) throws SQLException;

	public List<GroupCallback> selectHql(String hqlString) throws SQLException;

	public GroupCallback insert(GroupCallback bean) throws SQLException;

	public GroupCallback update(GroupCallback bean) throws SQLException;

}
