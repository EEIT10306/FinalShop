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
		State S = selectByPk(bean.getId());
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
		State S = selectByPk(bean.getId());
		// 有才修改
		if (S != null) {
			if (bean.getContext() != null)
				S.setContext(bean.getContext());
			if (bean.getClassName() != null)
				S.setClassName(bean.getClassName());
			return S;
		}
		return null;
	}

}
