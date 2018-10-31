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
		Achievement A = selectByPk(bean.getA_id());
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
		Achievement A = selectByPk(bean.getA_id());
		// 有才修改
		if (A != null) {
			if (bean.getA_context() != null)
				A.setA_context(bean.getA_context());
			if (bean.getA_amount() != null)
				A.setA_amount(bean.getA_amount());
			if (bean.getA_bonus() != null)
				A.setA_bonus(bean.getA_bonus());
			if (bean.getA_parentsId() != null)
				A.setA_parentsId(bean.getA_parentsId());
			return A;
		}
		return null;
	}

}
