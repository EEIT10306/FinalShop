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
		if (id != null)
			return null;
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
		GroupAssess GA = selectByPk(bean.getgA_id());
		if (GA == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupAssess update(GroupAssess bean) throws SQLException {
		GroupAssess GA = selectByPk(bean.getgA_id());
		if (GA != null) {
			if (bean.getgO_id() != null)
				GA.setgO_id(bean.getgO_id());
			if (bean.getgA_point() != null)
				GA.setgA_point(bean.getgA_point());
			if (bean.getgA_context() != null)
				GA.setgA_context(bean.getgA_context());
			if (bean.getgA_pointAssess() != null)
				GA.setgA_pointAssess(bean.getgA_pointAssess());
			if (bean.getgA_contextAssess() != null)
				GA.setgA_contextAssess(bean.getgA_contextAssess());
			return GA;
		}
		return null;
	}
}
