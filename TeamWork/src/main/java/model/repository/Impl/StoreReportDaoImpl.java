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
import model.bean.StoreReport;
import model.repository.StoreReportDao;

@Repository
public class StoreReportDaoImpl implements StoreReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		StoreReportDaoImpl dao = ctx.getBean(StoreReportDaoImpl.class);
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
	
	
	/* (non-Javadoc)
	 * @see model.repository.Impl.StoreReportDao#select()
	 */
	@Override
	public List<StoreReport> select() throws SQLException {
		return getSession().createQuery("from StoreReport", StoreReport.class).setMaxResults(50).list();
	}

	
	/* (non-Javadoc)
	 * @see model.repository.Impl.StoreReportDao#select(java.lang.Integer)
	 */
	@Override
	public StoreReport select(Integer id) throws SQLException {
		return getSession().get(StoreReport.class, id);
	}

	
	/* (non-Javadoc)
	 * @see model.repository.Impl.StoreReportDao#insert(model.bean.StoreReport)
	 */
	@Override
	public StoreReport insert(StoreReport bean) throws SQLException {
		StoreReport simple = getSession().get(StoreReport.class, bean.getId());
		if(simple==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	
	/* (non-Javadoc)
	 * @see model.repository.Impl.StoreReportDao#update(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public StoreReport update(Integer id, String context, Integer bonus, Integer parentsId) throws SQLException {
		return null;
	}

	
	/* (non-Javadoc)
	 * @see model.repository.Impl.StoreReportDao#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer id) throws SQLException {
		return false;
	}

}
