package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.GroupMessage;

public interface GroupMessageDao {

	public List<GroupMessage> selectAll() throws SQLException;

	public GroupMessage select(Integer id) throws SQLException;

	public GroupMessage insert(GroupMessage groupMessage) throws SQLException;

	public GroupMessage update(Integer id, Integer groupID, Integer memberID, Integer gmAmt, Date gmTime, Integer gsID,
			Integer sumPrice, Integer gmState) throws SQLException;

	public Boolean delete(Integer id) throws SQLException;
}
