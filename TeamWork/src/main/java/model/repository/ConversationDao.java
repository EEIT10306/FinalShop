package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.Conversation;

public interface ConversationDao {
	public List<Conversation> select() throws SQLException;
	public Conversation selectByPk(Conversation bean) throws SQLException;
	public Conversation insert(Conversation bean) throws SQLException;
	public Conversation update(Conversation bean) throws SQLException;
}
