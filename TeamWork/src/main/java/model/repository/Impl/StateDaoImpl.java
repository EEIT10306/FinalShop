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
	public List<State> selectAll() throws SQLException {
		List<State> LS = getSession().createQuery("from State", State.class).list();
		System.out.println(LS);
		return LS;
	}

	@Override
	public State selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		State S = getSession().get(State.class, id);
		System.out.println(S);
		return S;
	}

	@Override
	public List<State> selectHql(String hqlString) throws SQLException {
		String hql = "from State ";
		hql += hqlString;
		List<State> LGF = getSession().createQuery(hql, State.class).list();
		System.out.println(LGF);
		return LGF;
	}

	@Override
	public State insert(State bean) throws SQLException {
		// 查詢此ID有無資料
		State S = selectByPk(bean.getState_id());
		// 沒有才修改
		if (S == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public State update(State bean) throws SQLException {
		// 查詢此ID有無資料
		State S = selectByPk(bean.getState_id());
		// 有才修改
		if (S != null) {
			if (bean.getState_context() != null)
				S.setState_context(bean.getState_context());
			if (bean.getState_class() != null)
				S.setState_class(bean.getState_class());
			return S;
		}
		return null;
	}

	public State update(State S, State bean) throws SQLException {
		if (bean.getState_context() != null)
			S.setState_context(bean.getState_context());
		if (bean.getState_class() != null)
			S.setState_class(bean.getState_class());
		return S;
	}
}
