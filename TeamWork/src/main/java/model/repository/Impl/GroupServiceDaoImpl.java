package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupService;
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
	public GroupService select(Integer id) throws SQLException {
		return getSession().get(GroupService.class, id);
	}

	@Override
	public GroupService insert(GroupService groupService) throws SQLException {
		GroupService service = getSession().get(GroupService.class, groupService.getId());
		if (service == null) {
			getSession().save(groupService);
			return groupService;
		}
		return null;
	}

	@Override
	public GroupService update(Integer id, Integer groupProductID, String rule, Double off, Integer groupState)
			throws SQLException {
		GroupService groupService = getSession().get(GroupService.class, id);
		if (groupService != null) {
			groupService.setId(id);
			groupService.setGroupProductID(groupProductID);
			groupService.setRule(rule);
			groupService.setOff(off);
			groupService.setState(groupState);
			getSession().update(groupService);
			return groupService;
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		GroupService groupService = getSession().get(GroupService.class, id);
		if (groupService != null) {
			getSession().delete(groupService);
			return true;
		}
		return false;
	}
}
