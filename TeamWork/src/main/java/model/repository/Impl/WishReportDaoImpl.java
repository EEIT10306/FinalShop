package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.State;
import model.bean.WishProduct;
import model.bean.WishReport;
import model.repository.WishReportDao;

@Repository
public class WishReportDaoImpl implements WishReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishReport> select() throws SQLException {
		return getSession().createQuery("from WishReport", WishReport.class).setMaxResults(50).list();
	}

	@Override
	public WishReport selectByPk(WishReport bean) throws SQLException {
		return getSession().get(WishReport.class, bean.getId());
	}

	@Override
	public WishReport insert(WishReport bean) throws SQLException {
		WishReport wishReport = getSession().get(WishReport.class, bean.getId());
		if (wishReport == null) {
			State simpleState = getSession().get(State.class, bean.getState());
			Member member = getSession().get(Member.class, bean.getMemberID());
			WishProduct wishProduct = getSession().get(WishProduct.class, bean.getWishProductID());
			if(simpleState != null && member != null && wishProduct != null) {
								
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public WishReport update(WishReport bean) throws SQLException {
		WishReport wishReport = this.getSession().get(WishReport.class, bean.getId());
		if (wishReport != null) {
			State simpleState = getSession().get(State.class, bean.getState());
			Member member = getSession().get(Member.class, bean.getMemberID());
			WishProduct wishProduct = getSession().get(WishProduct.class, bean.getWishProductID());
			if(simpleState != null && member != null && wishProduct != null) {
				wishReport.setWishProductID(bean.getWishProductID());		
				wishReport.setMemberID(bean.getMemberID());
				wishReport.setContent(bean.getContent());
				wishReport.setState(bean.getState());
				getSession().update(wishReport);
				return wishReport;
			}
			
		}
		return null;
	}

}
