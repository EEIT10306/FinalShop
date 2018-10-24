package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Group;
import model.bean.Groupon;
import model.bean.WishProduct;
import model.repository.GroupDao;
import model.repository.GrouponDao;

@Repository
public class GrouponDaoImpl implements GrouponDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Groupon> select() throws SQLException {
		return getSession().createQuery("from Groupon", Groupon.class).setMaxResults(50).list();
	}

	@Override
	public Groupon select(Integer id) throws SQLException {
		return getSession().get(Groupon.class, id);
	}

	@Override
	public Groupon insert(Groupon bean) throws SQLException {
		Groupon simple = getSession().get(Groupon.class, bean.getId());
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Groupon update(Integer id, Integer memberId, Integer groupClass, String title, String cont,
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
