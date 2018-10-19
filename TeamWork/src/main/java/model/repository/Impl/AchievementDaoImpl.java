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
import model.repository.AchievementDao;
@Repository
public class AchievementDaoImpl implements AchievementDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		AchievementDaoImpl dao = ctx.getBean(AchievementDaoImpl.class);
		dao.getSession().beginTransaction();
			
		System.out.println(dao.select());//selectAll
//				
//		Achievement ach = new Achievement(null,"成就的內容", 10, null);
//		System.out.println(dao.getSession().save(ach));//insert
//				
//		System.out.println(dao.select(1));//selectOne
		
		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
	}
	@Override
	public List<Achievement> select() throws SQLException {
		return getSession().createQuery("from Achievement", Achievement.class).setMaxResults(50).list();
	}

	@Override
	public Achievement select(Integer id) throws SQLException {
		return getSession().get(Achievement.class, id);
	}

	@Override
	public Achievement insert(Achievement bean) throws SQLException {
		Achievement simple = getSession().get(Achievement.class, bean.getId());
		if(simple==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Achievement update(Integer id, String context, Integer bonus, Integer parentsId) throws SQLException {
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		return false;
	}

}
