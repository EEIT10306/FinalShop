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
		WishCallback WC = selectByPk(bean.getId());
		if (WC == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishCallback update(WishCallback bean) throws SQLException {
		WishCallback WC = selectByPk(bean.getId());
		if (WC != null) {
			if (bean.getWishMessageId() != null)
				WC.setWishMessageId(bean.getWishMessageId());
			if (bean.getMemberId() != null)
				WC.setMemberId(bean.getMemberId());
			if (bean.getContext() != null)
				WC.setContext(bean.getContext());
			if (bean.getTime() != null)
				WC.setTime(bean.getTime());
			if (bean.getStateId() != null)
				WC.setStateId(bean.getStateId());
			return WC;
		}
		return null;
	}
}
