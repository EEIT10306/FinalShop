package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupAssess;
import model.bean.GroupMessage;
import model.bean.State;
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
		return getSession().createQuery("from GroupAssess", GroupAssess.class).setMaxResults(50).list();
	}

	@Override
	public GroupAssess selectByPk(GroupAssess groupAssessBean) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, groupAssessBean.getId());
		if(groupAssess!=null) {
			return groupAssess;
		}
		return null;
	}

	@Override
	public GroupAssess insert(GroupAssess groupAssessBean) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, groupAssessBean.getId());
		if (groupAssess == null) {
			getSession().save(groupAssessBean);
			return groupAssessBean;
		}
		return null;
	}

	@Override
	public GroupAssess update(GroupAssess groupAssessBean) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, groupAssessBean.getId());
		if (groupAssess != null) {
			if (getSession().get(GroupMessage.class, groupAssessBean.getGroupMessageId()) != null) {
				if (getSession().get(State.class, groupAssessBean.getState()) != null) {
					groupAssess.setGroupMessageId(groupAssessBean.getGroupMessageId());
					groupAssess.setPoint(groupAssessBean.getPoint());
					groupAssess.setContext(groupAssessBean.getContext());
					groupAssess.setPointEE(groupAssessBean.getPointEE());
					groupAssess.setContextEE(groupAssessBean.getContextEE());
					groupAssess.setState(groupAssessBean.getState());
					return groupAssess;
				}
			}
		}
		return null;
	}
}
