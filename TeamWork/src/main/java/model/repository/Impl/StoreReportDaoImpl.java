package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.State;
import model.bean.StoreProduct;
import model.bean.StoreReport;
import model.repository.StoreReportDao;

@Repository
public class StoreReportDaoImpl implements StoreReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<StoreReport> select() throws SQLException {
		return getSession().createQuery("from StoreReport", StoreReport.class).setMaxResults(50).list();
	}

	@Override
	public StoreReport selectByPk(StoreReport bean) throws SQLException {
		return getSession().get(StoreReport.class, bean.getId());
	}

	@Override
	public StoreReport insert(StoreReport bean) throws SQLException {
		StoreReport storeReport = getSession().get(StoreReport.class, bean.getId());
		if(storeReport==null) {
			State simpleState = getSession().get(State.class, bean.getState());
			Member member = getSession().get(Member.class, bean.getMemberId());
			StoreProduct storeProduct = getSession().get(StoreProduct.class, bean.getStoreProductId());
			if(simpleState != null && member != null && storeProduct != null) {
				
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public StoreReport update(StoreReport bean) throws SQLException {
		StoreReport storeReport = this.getSession().get(StoreReport.class, bean.getId());
		if(storeReport != null) {
			State simpleState = getSession().get(State.class, bean.getState());
			Member member = getSession().get(Member.class, bean.getMemberId());
			StoreProduct storeProduct = getSession().get(StoreProduct.class, bean.getStoreProductId());
			if(simpleState != null && member != null && storeProduct != null) {
				
				storeReport.setStoreProductId(bean.getStoreProductId());
				storeReport.setMemberId(bean.getMemberId());
				storeReport.setContent(bean.getContent());
				storeReport.setState(bean.getState());
				getSession().update(storeReport);
				return storeReport;
			}
		}
		return null;
	}
}
