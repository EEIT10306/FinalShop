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
import model.bean.StoreAssess;
import model.repository.StoreAssessDao;


@Repository
public class StoreAssessDaoImpl implements StoreAssessDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		StoreAssessDaoImpl dao = ctx.getBean(StoreAssessDaoImpl.class);
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
	public List<StoreAssess> select() throws SQLException {
		return getSession().createQuery("from StoreAssess", StoreAssess.class).setMaxResults(50).list();
	}

	@Override
	public StoreAssess select(Integer id) throws SQLException {
		return getSession().get(StoreAssess.class, id);
	}

	@Override
	public StoreAssess insert(StoreAssess bean) throws SQLException {
		StoreAssess storeAssess = getSession().get(StoreAssess.class, bean.getId());
		if(storeAssess==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreAssess update(Integer id, Integer storeassessPoint,String storeassessContent,Integer storeassessPointee,String storeassessContee) throws SQLException {
		StoreAssess storeReport = this.getSession().get(StoreAssess.class, id);
		if(storeReport != null) {
			storeReport.setId(id);
			storeReport.setStoreassessPoint(storeassessPoint);
			storeReport.setStoreassessContent(storeassessContent);
			storeReport.setStoreassessPointee(storeassessPointee);
			storeReport.setStoreassessContee(storeassessContee);
			getSession().update(storeReport);
			return storeReport;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		StoreAssess storeAssess = this.getSession().get(StoreAssess.class, id);
		if(storeAssess != null) {
			getSession().delete(storeAssess);
			return true;
		}
		return false;
	}

}
