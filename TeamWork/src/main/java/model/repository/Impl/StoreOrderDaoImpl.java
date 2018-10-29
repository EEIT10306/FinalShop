package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreOrder;
import model.repository.StoreOrderDao;

@Repository
public class StoreOrderDaoImpl implements StoreOrderDao {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreOrder> selectAll() throws SQLException {
		List<StoreOrder> LSO = getSession().createQuery("From StoreOrder", StoreOrder.class).list();
		System.out.println(LSO);
		return LSO;
	}

	@Override
	public StoreOrder selectByPk(Integer id) throws SQLException {
		StoreOrder SO = getSession().get(StoreOrder.class, id);
		System.out.println(SO);
		return SO;
	}
	
	@Override
	public List<StoreOrder> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreOrder ";
		hql += hqlString;
		List<StoreOrder> SO = getSession().createQuery(hql, StoreOrder.class).list();
		System.out.println(SO);
		return SO;
	}

	@Override
	public StoreOrder insert(StoreOrder bean) throws SQLException {
		StoreOrder SO = selectByPk(bean.getId());
		if (SO == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreOrder update(StoreOrder bean) throws SQLException {
		StoreOrder SO = selectByPk(bean.getId());
		if (SO != null) {
			if (bean.getStoreProductId() != null)
				SO.setStoreProductId(bean.getStoreProductId());
			if (bean.getMemberId() != null)
				SO.setMemberId(bean.getMemberId());
			if (bean.getAmount() != null)
				SO.setAmount(bean.getAmount());
			if (bean.getStateId() != null)
				SO.setStateId(bean.getStateId());
			return SO;
		}
		return null;
	}
}
