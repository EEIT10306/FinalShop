package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishCallback;
import model.repository.WishCallbackDao;

@Repository
public class WishCallbackDaoImpl implements WishCallbackDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishCallback> selectAll() throws SQLException {
		List<WishCallback> LWC = getSession().createQuery("from WishCallback", WishCallback.class).list();
		System.out.println(LWC);
		return LWC;
	}

	@Override
	public WishCallback selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		WishCallback WC = getSession().get(WishCallback.class, id);
		System.out.println(WC);
		return WC;
	}

	@Override
	public List<WishCallback> selectHql(String hqlString) throws SQLException {
		String hql = "from WishCallback ";
		hql += hqlString;
		List<WishCallback> LWC = getSession().createQuery(hql, WishCallback.class).list();
		System.out.println(LWC);
		return LWC;
	}

	@Override
	public WishCallback insert(WishCallback bean) throws SQLException {
		WishCallback WC = selectByPk(bean.getwC_id());
		if (WC == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishCallback update(WishCallback bean) throws SQLException {
		WishCallback WC = selectByPk(bean.getwC_id());
		if (WC != null) {
			if (bean.getwM_id() != null)
				WC.setwM_id(bean.getwM_id());
			if (bean.getM_idCallback() != null)
				WC.setM_idCallback(bean.getM_idCallback());
			if (bean.getwC_context() != null)
				WC.setwC_context(bean.getwC_context());
			if (bean.getwC_time() != null)
				WC.setwC_time(bean.getwC_time());
			if (bean.getwC_stateId() != null)
				WC.setwC_stateId(bean.getwC_stateId());
			return WC;
		}
		return null;
	}
}
