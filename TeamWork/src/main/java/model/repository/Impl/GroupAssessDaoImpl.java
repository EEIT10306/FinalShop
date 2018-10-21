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
import model.bean.GroupAssess;
import model.repository.GroupAssessDao;

@Repository
public class GroupAssessDaoImpl implements GroupAssessDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		GroupAssessDaoImpl dao = ctx.getBean(GroupAssessDaoImpl.class);
		dao.getSession().beginTransaction();
		System.out.println(dao.selectAll());
		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
	}

	@Override
	public List<GroupAssess> selectAll() throws SQLException {
		return getSession().createQuery("from GroupAssess", GroupAssess.class).setMaxResults(50).list();
	}

	@Override
	public GroupAssess select(Integer id) throws SQLException {
		return getSession().get(GroupAssess.class, id);
	}

	@Override
	public GroupAssess insert(GroupAssess assess) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, assess.getId());
		if (groupAssess == null) {
			getSession().save(assess);
			return assess;
		}
		return null;
	}

	@Override
	public GroupAssess update(Integer id, Integer gmID, Integer point, String cont, Integer pointee, String contee,
			Integer gaState) throws SQLException {
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		return false;
	}
}
