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
		StoreAssess SA = selectByPk(bean.getId());
		if (SA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreAssess update(StoreAssess bean) throws SQLException {
		StoreAssess SA = selectByPk(bean.getId());
		if (SA != null) {
			if (bean.getStoreOrderId() != null)
				SA.setStoreOrderId(bean.getStoreOrderId());
			if (bean.getPoint() != null)
				SA.setPoint(bean.getPoint());
			if (bean.getContent() != null)
				SA.setContent(bean.getContent());
			if (bean.getPointEE() != null)
				SA.setPointEE(bean.getPointEE());
			if (bean.getContextEE() != null)
				SA.setContextEE(bean.getContextEE());
			return SA;
		}
		return null;
	}

}
