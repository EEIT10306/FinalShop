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
import model.bean.WishAssess;
import model.repository.WishAssessDao;


@Repository
public class WishAssessDaoImpl implements WishAssessDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);

		WishAssessDaoImpl dao = ctx.getBean(WishAssessDaoImpl.class);
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
	public List<WishAssess> select() throws SQLException {
		return getSession().createQuery("from WishAssess", WishAssess.class).setMaxResults(50).list();
	}
	
	@Override
	public WishAssess select(Integer id) throws SQLException {
		return getSession().get(WishAssess.class, id);
	}

	@Override
	public WishAssess insert(WishAssess bean) throws SQLException {
		WishAssess wishAssess = getSession().get(WishAssess.class, bean.getId());
		if(wishAssess==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishAssess update(Integer id, Integer point,String content,Integer pointee,String contee) throws SQLException {
		WishAssess wishAssess = this.getSession().get(WishAssess.class, id);
		if(wishAssess != null) {
			wishAssess.setId(id);
			wishAssess.setPoint(point);
			wishAssess.setContent(content);
			wishAssess.setPointee(pointee);
			wishAssess.setContee(contee);
			getSession().update(wishAssess);
			return wishAssess;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		WishAssess wishAssess = this.getSession().get(WishAssess.class, id);
		if(wishAssess != null) {
			getSession().delete(wishAssess);
			return true;
		}
		return false;
	}

}
