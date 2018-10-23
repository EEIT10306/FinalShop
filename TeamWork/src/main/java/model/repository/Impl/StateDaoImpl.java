package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.State;
import model.repository.StateDao;

@Repository
public class StateDaoImpl implements StateDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<State> select() throws SQLException {
		System.out.println(getSession().createQuery("from State", State.class).setMaxResults(50).list());
		return getSession().createQuery("from State", State.class).setMaxResults(50).list();
	}

	@Override
	public State select(Integer id) throws SQLException {
		System.out.println(getSession().get(State.class, id));
		return getSession().get(State.class, id);
	}

	@Override
	public State insert(State bean) throws SQLException {
		// 查詢此ID有無資料
		State simple = getSession().get(State.class, bean.getId());
		// 沒有才修改
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public State update(Integer id, String context, String className) throws SQLException {
		// 查詢此ID有無資料
		State simple = getSession().get(State.class, id);
		// 有才修改
		if (simple != null) {
			simple.setContext(context);
			simple.setClassName(className);
			return simple;
		}
		return null;
	}

}
