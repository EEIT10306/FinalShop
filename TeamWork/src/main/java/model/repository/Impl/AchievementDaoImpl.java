package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Achievement;
import model.repository.AchievementDao;

@Repository
public class AchievementDaoImpl implements AchievementDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Achievement> selectAll() throws SQLException {
		List<Achievement> LA = getSession().createQuery("from Achievement", Achievement.class).list();
		System.out.println(LA);
		return LA;
	}

	@Override
	public Achievement selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		Achievement A = getSession().get(Achievement.class, id);
		System.out.println(A);
		return A;

	}

	@Override
	public Achievement insert(Achievement bean) throws SQLException {
		// 查詢此ID有無資料
		Achievement A = selectByPk(bean.getId());
		// 沒有才新增
		if (A == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public List<Achievement> selectHql(String hqlString) throws SQLException {
		String hql = "from Achievement ";
		hql += hqlString;
		List<Achievement> LA = getSession().createQuery(hql, Achievement.class).list();
		System.out.println(LA);
		return LA;
	}

	@Override
	public Achievement update(Achievement bean) throws SQLException {
		// 查詢此ID有無資料
		Achievement A = selectByPk(bean.getId());
		// 有才修改
		if (A != null) {
			if (bean.getContext() != null)
				A.setContext(bean.getContext());
			if (bean.getBonus() != null)
				A.setBonus(bean.getBonus());
			if (bean.getParentsId() != null)
				A.setParentsId(bean.getParentsId());
			return A;
		}
		return null;
	}

}
