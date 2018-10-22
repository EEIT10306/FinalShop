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
import model.bean.GroupService;
import model.repository.GroupServiceDao;

@Repository
public class GroupServiceDaoImpl implements GroupServiceDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		GroupServiceDaoImpl dao = ctx.getBean(GroupServiceDaoImpl.class);
		dao.getSession().beginTransaction();
		System.out.println(dao.selectAll());
		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
	}

	@Override
	public List<GroupService> selectAll() throws SQLException {
		return getSession().createQuery("from GroupService" , GroupService.class).setMaxResults(50).list();
	}

	@Override
	public GroupService select(Integer id) throws SQLException {
		return getSession().get(GroupService.class, id);
	}

	@Override
	public GroupService insert(GroupService groupService) throws SQLException {
		GroupService service = getSession().get(GroupService.class, groupService.getId());
		if(service==null) {
			getSession().save(groupService);
			return groupService;
		}
		return null;
	}

	@Override
	public GroupService update(Integer id, Integer groupID, String rule, Double off, Integer groupState)
			throws SQLException {
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		return false;
	}
}
