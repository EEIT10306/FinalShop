package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupMessage;

public interface GroupMessageDao {

	public List<GroupMessage> selectAll() throws SQLException;

	public GroupMessage selectByPk(GroupMessage groupMessageBean) throws SQLException;

	public GroupMessage insert(GroupMessage groupMessageBean) throws SQLException;

	public GroupMessage update(GroupMessage groupMessageBean) throws SQLException;
}
