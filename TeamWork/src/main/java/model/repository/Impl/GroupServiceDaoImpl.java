package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupProduct;
import model.bean.GroupService;
import model.bean.State;
import model.repository.GroupServiceDao;

@Repository
public class GroupServiceDaoImpl implements GroupServiceDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupService> selectAll() throws SQLException {
		return getSession().createQuery("from GroupService", GroupService.class).setMaxResults(50).list();
	}

	@Override
	public GroupService selectByPk(GroupService groupServiceBean) throws SQLException {
		GroupService groupService = getSession().get(GroupService.class, groupServiceBean.getId());
		if (groupService != null) {
			return groupService;
		}
		return null;
	}

	@Override
	public GroupService insert(GroupService groupServiceBean) throws SQLException {
		GroupService groupService = getSession().get(GroupService.class, groupServiceBean.getId());
		if (groupService == null) {
			getSession().save(groupServiceBean);
			return groupServiceBean;
		}
		return null;
	}

	@Override
	public GroupService update(GroupService groupServiceBean) throws SQLException {
		GroupService groupService = getSession().get(GroupService.class, groupServiceBean.getId());
		if (groupService != null) {
			if (getSession().get(GroupProduct.class, groupServiceBean.getGroupProductID()) != null) {
				if (getSession().get(State.class, groupServiceBean.getState()) != null) {
					groupService.setGroupProductID(groupServiceBean.getGroupProductID());
					groupService.setRule(groupServiceBean.getRule());
					groupService.setOff(groupServiceBean.getOff());
					groupService.setState(groupServiceBean.getState());
					return groupService;
				}
			}
		}
		return null;
	}
}
