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
		if (id == null)
			return null;
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
		StoreOrder SO = selectByPk(bean.getsO_id());
		if (SO == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreOrder update(StoreOrder bean) throws SQLException {
		StoreOrder SO = selectByPk(bean.getsO_id());
		if (SO != null) {
			if (bean.getsP_id() != null)
				SO.setsP_id(bean.getsP_id());
			if (bean.getM_idOrder() != null)
				SO.setM_idOrder(bean.getM_idOrder());
			if (bean.getsO_transport() != null)
				SO.setsO_transport(bean.getsO_transport());
			if (bean.getsO_pay() != null)
				SO.setsO_pay(bean.getsO_pay());
			if (bean.getsO_remarks() != null)
				SO.setsO_remarks(bean.getsO_remarks());
			if (bean.getsO_amount() != null)
				SO.setsO_amount(bean.getsO_amount());
			if (bean.getsO_sumPrice() != null)
				SO.setsO_sumPrice(bean.getsO_sumPrice());
			if (bean.getsO_amount() != null)
				SO.setsO_amount(bean.getsO_stateId());
			return SO;
		}
		return null;
	}

	public StoreOrder update(StoreOrder SO, StoreOrder bean) throws SQLException {
		if (bean.getsP_id() != null)
			SO.setsP_id(bean.getsP_id());
		if (bean.getM_idOrder() != null)
			SO.setM_idOrder(bean.getM_idOrder());
		if (bean.getsO_transport() != null)
			SO.setsO_transport(bean.getsO_transport());
		if (bean.getsO_pay() != null)
			SO.setsO_pay(bean.getsO_pay());
		if (bean.getsO_remarks() != null)
			SO.setsO_remarks(bean.getsO_remarks());
		if (bean.getsO_amount() != null)
			SO.setsO_amount(bean.getsO_amount());
		if (bean.getsO_sumPrice() != null)
			SO.setsO_sumPrice(bean.getsO_sumPrice());
		if (bean.getsO_amount() != null)
			SO.setsO_amount(bean.getsO_stateId());
		return SO;
	}
}
