package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Conversation;
import model.bean.Member;
import model.bean.State;
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
		List<Conversation> simples = getSession().createQuery("from Conversation", Conversation.class).setMaxResults(50)
				.list();
		System.out.println(simples);
		return simples;
	}

	@Override
	public Conversation selectByPk(Conversation bean) throws SQLException {
		Conversation simple = getSession().get(Conversation.class, bean.getId());
		System.out.println(simple);
		return simple;
	}

	@Override
	public Conversation insert(Conversation bean) throws SQLException {
		// 查詢此ID有無資料
		Conversation simple = getSession().get(Conversation.class, bean.getId());
		// 沒有才修改
		if (simple == null) {
			// 外鍵有資料才新增
			State simpleState = getSession().get(State.class, bean.getState());
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			if (simpleState != null && simpleMember != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public Conversation update(Conversation bean) throws SQLException {
		// 查詢此ID有無資料
		Conversation simple = getSession().get(Conversation.class, bean.getId());
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才修改
			State simpleState = getSession().get(State.class, bean.getState());
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			if (simpleState != null && simpleMember != null) {
				simple.setMemberIdEE(bean.getMemberIdEE());
				simple.setMemberId(bean.getMemberId());
				simple.setContext(bean.getContext());
				simple.setAchievementID(bean.getAchievementID());
				simple.setState(bean.getState());
				return simple;
			}
		}
		return null;
	}

}
