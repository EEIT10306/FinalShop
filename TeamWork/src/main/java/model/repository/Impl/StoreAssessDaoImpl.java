package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreAssess;
import model.repository.StoreAssessDao;

@Repository
public class StoreAssessDaoImpl implements StoreAssessDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreAssess> selectAll() throws SQLException {
		List<StoreAssess> LSA = getSession().createQuery("from StoreAssess", StoreAssess.class).list();
		System.out.println(LSA);
		return LSA;
	}

	@Override
	public StoreAssess selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		StoreAssess SA = getSession().get(StoreAssess.class, id);
		System.out.println(SA);
		return SA;
	}

	@Override
	public List<StoreAssess> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreAssess ";
		hql += hqlString;
		List<StoreAssess> LSA = getSession().createQuery(hql, StoreAssess.class).list();
		System.out.println(LSA);
		return LSA;
	}

	@Override
	public StoreAssess insert(StoreAssess bean) throws SQLException {
		StoreAssess SA = selectByPk(bean.getsA_id());
		if (SA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreAssess update(StoreAssess bean) throws SQLException {
		StoreAssess SA = selectByPk(bean.getsA_id());
		if (SA != null) {
			if (bean.getsO_id() != null)
				SA.setsO_id(bean.getsO_id());
			if (bean.getsA_point() != null)
				SA.setsA_point(bean.getsA_point());
			if (bean.getsA_content() != null)
				SA.setsA_content(bean.getsA_content());
			if (bean.getsA_pointAssess() != null)
				SA.setsA_pointAssess(bean.getsA_pointAssess());
			if (bean.getsA_contextAssess() != null)
				SA.setsA_contextAssess(bean.getsA_contextAssess());
			return SA;
		}
		return null;
	}

	public StoreAssess update(StoreAssess SA, StoreAssess bean) throws SQLException {
		if (bean.getsO_id() != null)
			SA.setsO_id(bean.getsO_id());
		if (bean.getsA_point() != null)
			SA.setsA_point(bean.getsA_point());
		if (bean.getsA_content() != null)
			SA.setsA_content(bean.getsA_content());
		if (bean.getsA_pointAssess() != null)
			SA.setsA_pointAssess(bean.getsA_pointAssess());
		if (bean.getsA_contextAssess() != null)
			SA.setsA_contextAssess(bean.getsA_contextAssess());
		return SA;
	}
}
