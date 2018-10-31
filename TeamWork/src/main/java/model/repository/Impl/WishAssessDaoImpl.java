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
		if (id == null)
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
		WishAssess WA = selectByPk(bean.getwA_id());
		if (WA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishAssess update(WishAssess bean) throws SQLException {
		WishAssess WA = selectByPk(bean.getwA_id());
		if (WA != null) {
			if (bean.getwO_id() != null)
				WA.setwO_id(bean.getwO_id());
			if (bean.getwA_point() != null)
				WA.setwA_point(bean.getwA_point());
			if (bean.getwA_context() != null)
				WA.setwA_context(bean.getwA_context());
			if (bean.getwA_pointAssess() != null)
				WA.setwA_pointAssess(bean.getwA_pointAssess());
			if (bean.getwA_contextAssess() != null)
				WA.setwA_contextAssess(bean.getwA_contextAssess());
			return WA;
		}
		return null;
	}

}
