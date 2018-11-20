package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Analytics;
import model.repository.AnalyticsDao;

@Repository
public class AnalyticsDaoImpl implements AnalyticsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Analytics> selectAll() throws SQLException {
		List<Analytics> LA = getSession().createQuery("from Analytics", Analytics.class).list();
		System.out.println(LA);
		return LA;
	}

	@Override
	public Analytics selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		Analytics A = getSession().get(Analytics.class, id);
		System.out.println(A);
		return A;

	}

	@Override
	public Analytics insert(Analytics bean) throws SQLException {
		// 查詢此ID有無資料
		Analytics A = selectByPk(bean.getA_id());
		// 沒有才新增
		if (A == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public List<Analytics> selectHql(String hqlString) throws SQLException {
		String hql = "from Analytics ";
		hql += hqlString;
		List<Analytics> LA = getSession().createQuery(hql, Analytics.class).list();
		System.out.println(LA);
		return LA;
	}

	@Override
	public Analytics update(Analytics bean) throws SQLException {
		// 查詢此ID有無資料
		Analytics A = selectByPk(bean.getA_id());
		// 有才修改
		if (A != null) {
			if (bean.getA_date() != null)
				A.setA_date(bean.getA_date());
			if (bean.getA_tap() != null)
				A.setA_tap(bean.getA_tap());
			return A;
		}
		return null;
	}
	
	@Override
	public Analytics update(Analytics A, Analytics bean) throws SQLException {
		if (A != null) {
			if (bean.getA_date() != null)
				A.setA_date(bean.getA_date());
			if (bean.getA_tap() != null)
				A.setA_tap(bean.getA_tap());
			return A;
		}
		return null;
	}

}
