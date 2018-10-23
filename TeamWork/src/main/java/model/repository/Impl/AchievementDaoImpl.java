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
