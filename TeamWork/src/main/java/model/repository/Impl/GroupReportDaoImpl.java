package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupProduct;
import model.bean.GroupReport;
import model.bean.Member;
import model.bean.State;
import model.repository.GroupReportDao;

@Repository
public class GroupReportDaoImpl implements GroupReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupReport> select() throws SQLException {
		return getSession().createQuery("from GroupReport", GroupReport.class).setMaxResults(50).list();
	}

	@Override
	public GroupReport selectByPk(GroupReport bean) throws SQLException {
		return getSession().get(GroupReport.class, bean.getId());
	}

	@Override
	public GroupReport insert(GroupReport bean) throws SQLException {
		GroupReport groupReport = getSession().get(GroupReport.class, bean.getId());
		if(groupReport==null) {
			State simpleState = getSession().get(State.class, bean.getState());
			Member member = getSession().get(Member.class, bean.getId());
			GroupProduct groupProduct = getSession().get(GroupProduct.class, bean.getId());
			if(simpleState != null && member != null && groupProduct != null) {
								
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public GroupReport update(GroupReport bean) throws SQLException {
		GroupReport groupReport = this.getSession().get(GroupReport.class, bean.getId());
		if(groupReport != null) {
			State simpleState = getSession().get(State.class, bean.getState());
			Member member = getSession().get(Member.class, bean.getId());
			GroupProduct groupProduct = getSession().get(GroupProduct.class, bean.getId());
			if(simpleState != null && member != null && groupProduct != null) {
								
				groupReport.setProductId(bean.getProductId());
				groupReport.setMemberId(bean.getMemberId());;
				groupReport.setContent(bean.getContent());
				groupReport.setState(bean.getState());
				getSession().update(groupReport);
				return groupReport;
			}
		}
		return null;
	}

}
