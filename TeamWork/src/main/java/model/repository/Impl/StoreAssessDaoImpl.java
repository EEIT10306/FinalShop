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
import model.bean.State;
import model.bean.StoreAssess;
import model.bean.StoreOrder;
import model.repository.StoreAssessDao;

@Repository
public class StoreAssessDaoImpl implements StoreAssessDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreAssess> select() throws SQLException {
		return getSession().createQuery("from StoreAssess", StoreAssess.class).setMaxResults(50).list();
	}

	@Override
	public StoreAssess selectByPk(StoreAssess bean) throws SQLException {
		return getSession().get(StoreAssess.class, bean.getId());
	}

	@Override
	public StoreAssess insert(StoreAssess bean) throws SQLException {
		StoreAssess storeAssess = getSession().get(StoreAssess.class, bean.getId());
		if(storeAssess==null) {
			State simpleState = getSession().get(State.class, bean.getState());
			StoreOrder storeOrder = getSession().get(StoreOrder.class, bean.getStoreOrderId());
			if(simpleState != null && storeOrder != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public StoreAssess update(StoreAssess bean) throws SQLException {
		StoreAssess storeReport = this.getSession().get(StoreAssess.class, bean.getId());
		if(storeReport != null) {
			State simpleState = getSession().get(State.class, bean.getState());
			StoreOrder storeOrder = getSession().get(StoreOrder.class, bean.getStoreOrderId());
			if(simpleState != null && storeOrder != null) {
				storeReport.setPoint(bean.getPoint());
				storeReport.setContent(bean.getContent());
				storeReport.setPointEE(bean.getPointEE());
				storeReport.setContextEE(bean.getContextEE());
				getSession().update(storeReport);
				return storeReport;
			}
		}
		return null;
	}


}
