package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupMessage;

public interface GroupMessageDao {
	public List<GroupMessage> selectAll() throws SQLException;

	public GroupMessage selectByPk(Integer id) throws SQLException;

	public List<GroupMessage> selectHql(String hqlString) throws SQLException;

	public GroupMessage insert(GroupMessage bean) throws SQLException;

	public GroupMessage update(GroupMessage bean) throws SQLException;

}
