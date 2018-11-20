package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.XYAnalytics;
import model.repository.XYAnalyticsDao;

@Repository
public class XYAnalyticsDaoImpl implements XYAnalyticsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<XYAnalytics> selectAll() throws SQLException {
		List<XYAnalytics> LXYA = getSession().createQuery("from XYAnalytics", XYAnalytics.class).list();
		System.out.println(LXYA);
		return LXYA;
	}

	@Override
	public XYAnalytics selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		XYAnalytics XYA = getSession().get(XYAnalytics.class, id);
		System.out.println(XYA);
		return XYA;

	}

	@Override
	public XYAnalytics insert(XYAnalytics bean) throws SQLException {
		// 查詢此ID有無資料
		XYAnalytics XYA = selectByPk(bean.getXy_id());
		// 沒有才新增
		if (XYA == null) {
			bean.setXy_r(1.0);
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public List<XYAnalytics> selectHql(String hqlString) throws SQLException {
		String hql = "from XYAnalytics ";
		hql += hqlString;
		List<XYAnalytics> LXYA = getSession().createQuery(hql, XYAnalytics.class).list();
		System.out.println(LXYA);
		return LXYA;
	}

	@Override
	public XYAnalytics update(XYAnalytics bean) throws SQLException {
		// 查詢此ID有無資料
		XYAnalytics XYA = selectByPk(bean.getXy_id());
		// 有才修改
		if (XYA != null) {
			if (bean.getXy_date() != null)
				XYA.setXy_date(bean.getXy_date());
			if (bean.getXy_x() != null)
				XYA.setXy_x(bean.getXy_x());
			if (bean.getXy_y() != null)
				XYA.setXy_y(bean.getXy_y());
			if (bean.getXy_r() != null)
				XYA.setXy_r(bean.getXy_r());
			return XYA;
		}
		return null;
	}

	@Override
	public XYAnalytics update(XYAnalytics XYA, XYAnalytics bean) throws SQLException {
		if (XYA != null) {
			if (bean.getXy_date() != null)
				XYA.setXy_date(bean.getXy_date());
			if (bean.getXy_x() != null)
				XYA.setXy_x(bean.getXy_x());
			if (bean.getXy_y() != null)
				XYA.setXy_y(bean.getXy_y());
			if (bean.getXy_r() != null)
				XYA.setXy_r(bean.getXy_r());
			return XYA;
		}
		return null;
	}

}
