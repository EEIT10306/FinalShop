package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupAssess;
import model.repository.GroupAssessDao;

@Repository
public class GroupAssessDaoImpl implements GroupAssessDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupAssess> selectAll() throws SQLException {
		List<GroupAssess> LGA = getSession().createQuery("from GroupAssess", GroupAssess.class).list();
		System.out.println(LGA);
		return LGA;
	}

	@Override
	public GroupAssess selectByPk(Integer id) throws SQLException {
		GroupAssess GA = getSession().get(GroupAssess.class, id);
		System.out.println(GA);
		return GA;
	}

	@Override
	public List<GroupAssess> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupAssess ";
		hql += hqlString;
		List<GroupAssess> LGA = getSession().createQuery(hql, GroupAssess.class).list();
		System.out.println(LGA);
		return LGA;
	}

	@Override
	public GroupAssess insert(GroupAssess bean) throws SQLException {
		GroupAssess GA = selectByPk(bean.getId());
		if (GA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupAssess update(GroupAssess bean) throws SQLException {
		GroupAssess GA = selectByPk(bean.getId());
		if (GA != null) {
			if (bean.getGroupOrderId() != null)
				GA.setGroupOrderId(bean.getGroupOrderId());
			if (bean.getPoint() != null)
				GA.setPoint(bean.getPoint());
			if (bean.getContext() != null)
				GA.setContext(bean.getContext());
			if (bean.getPointEE() != null)
				GA.setPointEE(bean.getPointEE());
			if (bean.getContextEE() != null)
				GA.setContextEE(bean.getContextEE());
			return GA;
		}
		return null;
	}
}
