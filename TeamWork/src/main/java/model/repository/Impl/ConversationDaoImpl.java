package model.repository.Impl;

import java.sql.SQLException;
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
	public List<Conversation> selectAll() throws SQLException {
		List<Conversation> LC = getSession().createQuery("from Conversation", Conversation.class).list();
		System.out.println(LC);
		return LC;
	}

	@Override
	public Conversation selectByPk(Integer id) throws SQLException {
		Conversation C = getSession().get(Conversation.class, id);
		System.out.println(C);
		return C;
	}

	@Override
	public List<Conversation> selectHql(String hqlString) throws SQLException {
		String hql = "from Conversation ";
		hql += hqlString;
		List<Conversation> LC = getSession().createQuery(hql, Conversation.class).list();
		System.out.println(LC);
		return LC;
	}

	@Override
	public Conversation insert(Conversation bean) throws SQLException {
		// 查詢此ID有無資料
		Conversation C = selectByPk(bean.getId());
		// 沒有才修改
		if (C == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Conversation update(Conversation bean) throws SQLException {
		// 查詢此ID有無資料
		Conversation C = selectByPk(bean.getId());
		// 有才修改
		if (C != null) {
			C.setMemberIdEE(bean.getMemberIdEE());
			C.setMemberId(bean.getMemberId());
			C.setContext(bean.getContext());
			C.setTime(bean.getTime());
			C.setStateId(bean.getStateId());
			return C;
		}
		return null;
	}

}
