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
import model.bean.GroupReport;
import model.repository.GroupReportDao;

@Repository
public class GroupReportDaoImpl implements GroupReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		GroupReportDaoImpl dao = ctx.getBean(GroupReportDaoImpl.class);
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
	public List<GroupReport> select() throws SQLException {
		return getSession().createQuery("from GroupReport", GroupReport.class).setMaxResults(50).list();
	}

	@Override
	public GroupReport select(Integer id) throws SQLException {
		return getSession().get(GroupReport.class, id);
	}

	@Override
	public GroupReport insert(GroupReport bean) throws SQLException {
		GroupReport groupReport = getSession().get(GroupReport.class, bean.getId());
		if(groupReport==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupReport update(Integer id, String content) throws SQLException {
		GroupReport groupReport = this.getSession().get(GroupReport.class, id);
		if(groupReport != null) {
			groupReport.setId(id);
			groupReport.setContent(content);
			getSession().update(groupReport);
			return groupReport;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		GroupReport groupReport = this.getSession().get(GroupReport.class, id);
		if(groupReport != null) {
			getSession().delete(groupReport);
			return true;
		}
		return false;
	}

}
