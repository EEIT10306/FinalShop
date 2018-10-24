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
import model.bean.WishReport;
import model.repository.WishReportDao;

@Repository
public class WishReportDaoImpl implements WishReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		WishReportDaoImpl dao = ctx.getBean(WishReportDaoImpl.class);
		dao.getSession().beginTransaction();

		System.out.println(dao.select());// selectAll
//				
//		Achievement ach = new Achievement(null,"成就的內容", 10, null);
//		System.out.println(dao.getSession().save(ach));//insert
//				
//		System.out.println(dao.select(1));//selectOne

		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
	}

	@Override
	public List<WishReport> select() throws SQLException {
		return getSession().createQuery("from WishReport", WishReport.class).setMaxResults(50).list();
	}

	@Override
	public WishReport select(Integer id) throws SQLException {
		return getSession().get(WishReport.class, id);
	}

	@Override
	public WishReport insert(WishReport bean) throws SQLException {
		WishReport wishReport = getSession().get(WishReport.class, bean.getId());
		if (wishReport == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishReport update(Integer id, String content) throws SQLException {
		WishReport wishReport = this.getSession().get(WishReport.class, id);
		if (wishReport != null) {
			wishReport.setId(id);
			wishReport.setContent(content);
			getSession().update(wishReport);
			return wishReport;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
