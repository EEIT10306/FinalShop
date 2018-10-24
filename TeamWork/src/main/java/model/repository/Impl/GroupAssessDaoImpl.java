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
		return getSession().createQuery("from GroupAssess", GroupAssess.class).setMaxResults(50).list();
	}

	@Override
	public GroupAssess select(Integer id) throws SQLException {
		return getSession().get(GroupAssess.class, id);
	}

	@Override
	public GroupAssess insert(GroupAssess assess) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, assess.getId());
		if (groupAssess == null) {
			getSession().save(assess);
			return assess;
		}
		return null;
	}

	@Override
	public GroupAssess update(Integer id, Integer gmID, Integer point, String cont, Integer pointee, String contee,
			Integer gaState) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, id);
		if (groupAssess != null) {
			groupAssess.setId(id);
			groupAssess.setGroupMessageId(gmID);
			groupAssess.setPoint(point);
			groupAssess.setContext(cont);
			groupAssess.setPointEE(pointee);
			groupAssess.setContextEE(contee);
			groupAssess.setState(gaState);
			getSession().update(groupAssess);
			return groupAssess;
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		GroupAssess groupAssess = getSession().get(GroupAssess.class, id);
		if (groupAssess != null) {
			getSession().delete(groupAssess);
			return true;
		}
		return false;
	}
}
