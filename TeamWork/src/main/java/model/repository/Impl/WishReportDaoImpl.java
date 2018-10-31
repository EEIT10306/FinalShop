package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishReport;
import model.repository.WishReportDao;

@Repository
public class WishReportDaoImpl implements WishReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishReport> selectAll() throws SQLException {
		List<WishReport> LWR = getSession().createQuery("from WishReport", WishReport.class).list();
		System.out.println(LWR);
		return LWR;
	}

	@Override
	public WishReport selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		WishReport WR = getSession().get(WishReport.class, id);
		System.out.println(WR);
		return WR;
	}

	@Override
	public List<WishReport> selectHql(String hqlString) throws SQLException {
		String hql = "from WishReport ";
		hql += hqlString;
		List<WishReport> LWR = getSession().createQuery(hql, WishReport.class).list();
		System.out.println(LWR);
		return LWR;
	}

	@Override
	public WishReport insert(WishReport bean) throws SQLException {
		WishReport WR = selectByPk(bean.getwR_id());
		if (WR == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishReport update(WishReport bean) throws SQLException {
		WishReport WR = selectByPk(bean.getwR_id());
		if (WR != null) {
			if (bean.getW_id() != null)
				WR.setW_id(bean.getW_id());
			if (bean.getM_idReport() != null)
				WR.setM_idReport(bean.getM_idReport());
			if (bean.getwR_content() != null)
				WR.setwR_content(bean.getwR_content());
			if (bean.getwR_stateId() != null)
				WR.setwR_stateId(bean.getwR_stateId());
			return WR;
		}
		return null;
	}

}
