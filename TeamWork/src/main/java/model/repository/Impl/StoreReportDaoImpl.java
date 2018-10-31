package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreReport;
import model.repository.StoreReportDao;

@Repository
public class StoreReportDaoImpl implements StoreReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreReport> selectAll() throws SQLException {
		List<StoreReport> LSR = getSession().createQuery("from StoreReport", StoreReport.class).list();
		System.out.println(LSR);
		return LSR;
	}

	@Override
	public StoreReport selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		StoreReport SR = getSession().get(StoreReport.class, id);
		System.out.println(SR);
		return SR;
	}

	@Override
	public List<StoreReport> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreReport ";
		hql += hqlString;
		List<StoreReport> LSR = getSession().createQuery(hql, StoreReport.class).list();
		System.out.println(LSR);
		return LSR;
	}

	@Override
	public StoreReport insert(StoreReport bean) throws SQLException {
		StoreReport SR = selectByPk(bean.getsR_id());
		if (SR == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreReport update(StoreReport bean) throws SQLException {
		StoreReport SR = selectByPk(bean.getsR_id());
		if (SR != null) {
			if (bean.getsP_id() != null)
				SR.setsP_id(bean.getsP_id());
			if (bean.getM_idReport() != null)
				SR.setM_idReport(bean.getM_idReport());
			if (bean.getsR_content() != null)
				SR.setsR_content(bean.getsR_content());
			if (bean.getsR_stateId() != null)
				SR.setsR_stateId(bean.getsR_stateId());
			return SR;
		}
		return null;
	}
}
