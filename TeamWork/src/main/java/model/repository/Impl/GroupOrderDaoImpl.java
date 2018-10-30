package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupOrder;
import model.repository.GroupOrderDao;

@Repository
public class GroupOrderDaoImpl implements GroupOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupOrder> selectAll() throws SQLException {
		List<GroupOrder> LGO = getSession().createQuery("from GroupOrder", GroupOrder.class).list();
		System.out.println(LGO);
		return LGO;
	}

	@Override
	public GroupOrder selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		GroupOrder GO = getSession().get(GroupOrder.class, id);
		System.out.println(GO);
		return GO;
	}

	@Override
	public List<GroupOrder> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupOrder ";
		hql += hqlString;
		List<GroupOrder> LGO = getSession().createQuery(hql, GroupOrder.class).list();
		System.out.println(LGO);
		return LGO;
	}

	@Override
	public GroupOrder insert(GroupOrder bean) throws SQLException {
		GroupOrder GO = selectByPk(bean.getId());
		if (GO == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupOrder update(GroupOrder bean) throws SQLException {
		GroupOrder GO = selectByPk(bean.getId());
		if (GO != null) {
			if (bean.getGroupProductId() != null)
				GO.setGroupProductId(bean.getGroupProductId());
			if (bean.getMemberId() != null)
				GO.setMemberId(bean.getMemberId());
			if (bean.getAmount() != null)
				GO.setAmount(bean.getAmount());
			if (bean.getStateId() != null)
				GO.setStateId(bean.getStateId());
			return GO;
		}
		return null;
	}
}
