package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Conversation;
import model.repository.ConversationDao;

@Repository
public class ConversationDaoImpl implements ConversationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Conversation> select() throws SQLException {
		System.out.println(getSession().createQuery("from Conversation", Conversation.class).setMaxResults(50).list());
		return getSession().createQuery("from Conversation", Conversation.class).setMaxResults(50).list();
	}

	@Override
	public Conversation select(Integer id) throws SQLException {
		System.out.println(getSession().get(Conversation.class, id));
		return getSession().get(Conversation.class, id);
	}

	@Override
	public Conversation insert(Conversation bean) throws SQLException {
		// 查詢此ID有無資料
		Conversation simple = getSession().get(Conversation.class, bean.getId());
		// 沒有才修改
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Conversation update(Integer id, Integer memberIdEE, Integer memberId, String context, Date achievementID,
			Integer state) throws SQLException {
		// 查詢此ID有無資料
		Conversation simple = getSession().get(Conversation.class, id);
		// 有才修改
		if (simple != null) {
			simple.setMemberIdEE(memberIdEE);
			simple.setMemberId(memberId);
			simple.setContext(context);
			simple.setAchievementID(achievementID);
			simple.setState(state);
			return simple;
		}
		return null;
	}

}
