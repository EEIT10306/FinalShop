package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.CommitAchievement;
import model.repository.CommitAchievementDao;

@Repository
public class CommitAchievementDaoImpl implements CommitAchievementDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<CommitAchievement> selectAll() throws SQLException {
		List<CommitAchievement> LCA = getSession().createQuery("from CommitAchievement", CommitAchievement.class)
				.list();
		System.out.println(LCA);
		return LCA;
	}

	@Override
	public CommitAchievement selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		CommitAchievement CA = getSession().get(CommitAchievement.class, id);
		System.out.println(CA);
		return CA;
	}

	@Override
	public List<CommitAchievement> selectHql(String hqlString) throws SQLException {
		String hql = "from CommitAchievement ";
		hql += hqlString;
		List<CommitAchievement> LCA = getSession().createQuery(hql, CommitAchievement.class).list();
		System.out.println(LCA);
		return LCA;
	}

	@Override
	public CommitAchievement insert(CommitAchievement bean) throws SQLException {
		CommitAchievement CA = selectByPk(bean.getId());
		if (CA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public CommitAchievement update(CommitAchievement bean) throws SQLException {
		CommitAchievement CA = selectByPk(bean.getId());
		if (CA != null) {
			if (bean.getAchievementId() != null)
				CA.setAchievementId(bean.getAchievementId());
			if (bean.getMemberId() != null)
				CA.setMemberId(bean.getMemberId());
			if (bean.getStateId() != null)
				CA.setStateId(bean.getStateId());
			return CA;
		}
		return null;
	}

}
