package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import misc.SpringJavaConfiguration;
import model.bean.Achievement;
import model.bean.CommitAchievement;
import model.bean.Member;
import model.repository.CommitAchievementDao;

@Repository
public class CommitAchievementDaoImpl implements CommitAchievementDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<CommitAchievement> select() throws SQLException {
		return getSession().createQuery("from CommitAchievement", CommitAchievement.class).setMaxResults(50).list();
	}

	@Override
	public CommitAchievement selectByPk(Integer id) throws SQLException {
		return getSession().get(CommitAchievement.class, id);
	}

	@Override
	public CommitAchievement insert(CommitAchievement bean) throws SQLException {
		CommitAchievement simple = getSession().get(CommitAchievement.class, bean.getId());
		if (simple == null) {
			Achievement achievement = getSession().get(Achievement.class, bean.getAchievementID());
			Member member = getSession().get(Member.class, bean.getMemberID());
			if (achievement != null && member != null) {
				getSession().save(bean);
				return bean;
			}
			return null;
		}
		return null;
	}

	@Override
	public CommitAchievement update(CommitAchievement bean) throws SQLException {
		CommitAchievement CA = getSession().get(CommitAchievement.class, bean.getId());
		if (CA != null) {
			Achievement achievement = getSession().get(Achievement.class, bean.getAchievementID());
			Member member = getSession().get(Member.class, bean.getMemberID());
			if (achievement != null && member != null) {
				CA.setAchievementID(bean.getAchievementID());
				CA.setMemberID(bean.getMemberID());
				return CA;
			}
			return null;
		}
		return null;
	}

}
