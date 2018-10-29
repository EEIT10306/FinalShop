package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Conversation;

public interface ConversationDao {
	public List<Conversation> selectAll() throws SQLException;

	public Conversation selectByPk(Integer id) throws SQLException;

	public List<Conversation> selectHql(String hqlString) throws SQLException;

	public Conversation insert(Conversation bean) throws SQLException;

	public Conversation update(Conversation bean) throws SQLException;

}
