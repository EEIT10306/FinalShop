package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import misc.SpringJavaConfiguration;
import model.bean.GroupMessage;
import model.repository.GroupMessageDao;

@Repository
public class GroupMessageDaoImpl implements GroupMessageDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		GroupMessageDaoImpl dao = ctx.getBean(GroupMessageDaoImpl.class);
		dao.getSession().beginTransaction();
		System.out.println(dao.selectAll());
		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
	}

	@Override
	public List<GroupMessage> selectAll() throws SQLException {
		return getSession().createQuery("from GroupMessage", GroupMessage.class).setMaxResults(50).list();
	}

	@Override
	public GroupMessage select(Integer id) throws SQLException {
		return getSession().get(GroupMessage.class, id);
	}

	@Override
	public GroupMessage insert(GroupMessage groupMessage) throws SQLException {
		GroupMessage message = getSession().get(GroupMessage.class, groupMessage.getId());
		if (message == null) {
			getSession().save(groupMessage);
			return groupMessage;
		}
		return null;
	}

	@Override
	public GroupMessage update(Integer id, Integer groupID, Integer memberID, Integer gmAmt, Date gmTime, Integer gsID,
			Integer sumPrice, Integer gmState) throws SQLException {
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		return false;
	}
}
