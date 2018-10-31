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
		if (id == null)
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
		GroupOrder GO = selectByPk(bean.getgO_id());
		if (GO == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupOrder update(GroupOrder bean) throws SQLException {
		GroupOrder GO = selectByPk(bean.getgO_id());
		if (GO != null) {
			if (bean.getgP_id() != null)
				GO.setgP_id(bean.getgP_id());
			if (bean.getM_idOrder() != null)
				GO.setM_idOrder(bean.getM_idOrder());
			if (bean.getgO_amount() != null)
				GO.setgO_amount(bean.getgO_amount());
			if (bean.getgO_stateId() != null)
				GO.setgO_stateId(bean.getgO_stateId());
			return GO;
		}
		return null;
	}
}
