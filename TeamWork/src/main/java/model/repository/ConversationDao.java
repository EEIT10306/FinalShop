package model.repository;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.Conversation;

public interface ConversationDao {
	public List<Conversation> select() throws SQLException;
	public Conversation select(Integer id) throws SQLException;
	public Conversation insert(Conversation bean) throws SQLException;
	public Conversation update(Integer id, Integer memberIdEE, Integer memberId, String context, Date achievementID,
			Integer state) throws SQLException;
}
