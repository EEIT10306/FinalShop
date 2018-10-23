package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Group;
import model.bean.WishProduct;
import model.repository.GroupDao;

@Repository
public class GroupDaoImpl implements GroupDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Group> select() throws SQLException {
		return getSession().createQuery("from Group", Group.class).setMaxResults(50).list();
	}

	@Override
	public Group select(Integer id) throws SQLException {
		return getSession().get(Group.class, id);
	}

	@Override
	public Group insert(Group bean) throws SQLException {
		Group simple = getSession().get(Group.class, bean.getId());
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Group update(Integer id, Integer memberId, Integer groupClass, String title, String cont,
			Integer districtTypeId, Date startDate, Date endDate, String goal, Date compTime, Integer state)
			throws SQLException {
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
