package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreCallback;
import model.repository.StoreCallbackDao;

@Repository
public class StoreCallbackDaoImpl implements StoreCallbackDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreCallback> selectAll() throws SQLException {
		List<StoreCallback> LSC = getSession().createQuery("from StoreCallback", StoreCallback.class).list();
		System.out.println(LSC);
		return LSC;
	}

	@Override
	public StoreCallback selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		StoreCallback SC = getSession().get(StoreCallback.class, id);
		System.out.println(SC);
		return SC;
	}

	@Override
	public List<StoreCallback> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreCallback ";
		hql += hqlString;
		List<StoreCallback> LSC = getSession().createQuery(hql, StoreCallback.class).list();
		System.out.println(LSC);
		return LSC;
	}

	@Override
	public StoreCallback insert(StoreCallback bean) throws SQLException {
		StoreCallback SC = selectByPk(bean.getId());
		if (SC == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreCallback update(StoreCallback bean) throws SQLException {
		StoreCallback SC = selectByPk(bean.getId());
		if (SC != null) {
			if (bean.getStoreMessageId() != null)
				SC.setStoreMessageId(bean.getStoreMessageId());
			if (bean.getMemberId() != null)
				SC.setMemberId(bean.getMemberId());
			if (bean.getContext() != null)
				SC.setContext(bean.getContext());
			if (bean.getTime() != null)
				SC.setTime(bean.getTime());
			if (bean.getStateId() != null)
				SC.setStateId(bean.getStateId());
			return SC;
		}
		return null;
	}
}
