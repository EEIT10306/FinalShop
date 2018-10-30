package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishAssess;
import model.repository.WishAssessDao;

@Repository
public class WishAssessDaoImpl implements WishAssessDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishAssess> selectAll() throws SQLException {
		List<WishAssess> LWA = getSession().createQuery("from WishAssess", WishAssess.class).list();
		System.out.println(LWA);
		return LWA;
	}

	@Override
	public WishAssess selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		WishAssess WA = getSession().get(WishAssess.class, id);
		System.out.println(WA);
		return WA;
	}

	@Override
	public List<WishAssess> selectHql(String hqlString) throws SQLException {
		String hql = "from WishAssess ";
		hql += hqlString;
		List<WishAssess> LWA = getSession().createQuery(hql, WishAssess.class).list();
		System.out.println(LWA);
		return LWA;
	}

	@Override
	public WishAssess insert(WishAssess bean) throws SQLException {
		WishAssess WA = selectByPk(bean.getId());
		if (WA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishAssess update(WishAssess bean) throws SQLException {
		WishAssess WA = selectByPk(bean.getId());
		if (WA != null) {
			if (bean.getPoint() != null)
				WA.setPoint(bean.getPoint());
			if (bean.getContext() != null)
				WA.setContext(bean.getContext());
			if (bean.getPointEE() != null)
				WA.setPointEE(bean.getPointEE());
			if (bean.getContextEE() != null)
				WA.setContextEE(bean.getContextEE());
			return WA;
		}
		return null;
	}

}
