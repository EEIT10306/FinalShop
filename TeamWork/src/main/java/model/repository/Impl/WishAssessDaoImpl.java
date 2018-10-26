package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.State;
import model.bean.WishAssess;
import model.bean.WishMessage;
import model.repository.WishAssessDao;


@Repository
public class WishAssessDaoImpl implements WishAssessDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<WishAssess> select() throws SQLException {
		return getSession().createQuery("from WishAssess", WishAssess.class).setMaxResults(50).list();
	}
	
	@Override
	public WishAssess selectByPk(WishAssess bean) throws SQLException {
		return getSession().get(WishAssess.class, bean.getId());
	}

	@Override
	public WishAssess insert(WishAssess bean) throws SQLException {
		WishAssess wishAssess = getSession().get(WishAssess.class, bean.getId());
		if(wishAssess==null) {
			State simpleState = getSession().get(State.class, bean.getState());
			WishMessage wishMessage = getSession().get(WishMessage.class, bean.getId());
			if(simpleState != null && wishMessage != null) {
				
				getSession().save(bean);
				return bean;
			}
			
		}
		return null;
	}

	@Override
	public WishAssess update(WishAssess bean) throws SQLException {
		WishAssess wishAssess = this.getSession().get(WishAssess.class, bean.getId());
		if(wishAssess != null) {
			State simpleState = getSession().get(State.class, bean.getState());
			WishMessage wishMessage = getSession().get(WishMessage.class, bean.getId());
			if(simpleState != null && wishMessage != null) {
				
				wishAssess.setPoint(bean.getPoint());
				wishAssess.setContext(bean.getContext());
				wishAssess.setPointEE(bean.getPointEE());
				wishAssess.setContextEE(bean.getContextEE());
				getSession().update(wishAssess);
				return wishAssess;
			}
		}
		return null;
	}

}
