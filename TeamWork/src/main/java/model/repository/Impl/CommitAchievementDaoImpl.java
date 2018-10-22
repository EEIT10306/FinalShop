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
import model.repository.CommitAchievementDao;

@Repository
public class CommitAchievementDaoImpl implements CommitAchievementDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		CommitAchievementDaoImpl dao = ctx.getBean(CommitAchievementDaoImpl.class);
		dao.getSession().beginTransaction();

		System.out.println(dao.select());//selectAll
				
//		CommitAchievement comAch = new CommitAchievement(1, 1 , 2);
//		System.out.println(dao.getSession().save(comAch));// insert
//		
//		System.out.println(dao.select(1));//selectOne

		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
	}

	@Override
	public List<CommitAchievement> select() throws SQLException {
		return getSession().createQuery("from CommitAchievement", CommitAchievement.class).setMaxResults(50).list();
	}

	@Override
	public CommitAchievement select(Integer id) throws SQLException {
		return getSession().get(CommitAchievement.class, id);
	}

	@Override
	public CommitAchievement insert(CommitAchievement bean) throws SQLException {
		CommitAchievement simple = getSession().get(CommitAchievement.class, bean.getId());
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public CommitAchievement update(Integer id, Integer achievementID, Integer memberID) throws SQLException {
		CommitAchievement CA = getSession().get(CommitAchievement.class, id);
		if(CA != null) {
			CA.setAchievementID(achievementID);
			CA.setMemberID(memberID);
			getSession().update(CA);
			return CA;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		CommitAchievement CA = getSession().get(CommitAchievement.class, id);
		if(CA != null) {
			getSession().delete(CA);
			return true;
		}
		return false;
	}

}
