package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishOrder;
import model.repository.WishOrderDao;

@Repository
public class WishOrderDaoImpl implements WishOrderDao {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishOrder> selectAll() throws SQLException {
		List<WishOrder> LWO = getSession().createQuery("From WishOrder", WishOrder.class).list();
		System.out.println(LWO);
		return LWO;
	}

	@Override
	public WishOrder selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		WishOrder WO = getSession().get(WishOrder.class, id);
		System.out.println(WO);
		return WO;
	}

	@Override
	public List<WishOrder> selectHql(String hqlString) throws SQLException {
		String hql = "from WishOrder ";
		hql += hqlString;
		List<WishOrder> WO = getSession().createQuery(hql, WishOrder.class).list();
		System.out.println(WO);
		return WO;
	}

	@Override
	public WishOrder insert(WishOrder bean) throws SQLException {
		WishOrder WO = selectByPk(bean.getwO_id());
		if (WO == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishOrder update(WishOrder bean) throws SQLException {
		WishOrder WO = selectByPk(bean.getwO_id());
		if (WO != null) {
			if (bean.getW_id() != null)
				WO.setW_id(bean.getW_id());
			if (bean.getM_idOrder() != null)
				WO.setM_idOrder(bean.getM_idOrder());
			if (bean.getwO_sumPrice() != null)
				WO.setwO_sumPrice(bean.getwO_sumPrice());
			if (bean.getwO_time() != null)
				WO.setwO_time(bean.getwO_time());
			if (bean.getwO_stateId() != null)
				WO.setwO_stateId(bean.getwO_stateId());
			return WO;
		}
		return null;
	}
}
