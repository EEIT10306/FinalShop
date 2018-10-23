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

	@Override
	public List<Achievement> select() throws SQLException {
		System.out.println(getSession().createQuery("from Achievement", Achievement.class).setMaxResults(50).list());
		return getSession().createQuery("from Achievement", Achievement.class).setMaxResults(50).list();
	}

	@Override
	public Achievement select(Integer id) throws SQLException {
		System.out.println(getSession().get(Achievement.class, id));
		return getSession().get(Achievement.class, id);
	}

	@Override
	public Achievement insert(Achievement bean) throws SQLException {
		// 查詢此ID有無資料
		Achievement simple = getSession().get(Achievement.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Achievement update(Integer id, String context, Integer bonus, Integer parentsId) throws SQLException {
		// 查詢此ID有無資料
		Achievement simple = getSession().get(Achievement.class, id);
		// 有才修改
		if (simple != null) {
			simple.setContext(context);
			simple.setBonus(bonus);
			simple.setParentsId(parentsId);
			return simple;
		}
		return null;
	}

}
