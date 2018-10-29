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
		WishOrder WO = selectByPk(bean.getId());
		if (WO == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishOrder update(WishOrder bean) throws SQLException {
		WishOrder WO = selectByPk(bean.getId());
		if (WO != null) {
			if (bean.getWishId() != null)
				WO.setWishId(bean.getWishId());
			if (bean.getMemberId() != null)
				WO.setMemberId(bean.getMemberId());
			if (bean.getSumPrice() != null)
				WO.setSumPrice(bean.getSumPrice());
			if (bean.getTime() != null)
				WO.setTime(bean.getTime());
			if (bean.getStateId() != null)
				WO.setStateId(bean.getStateId());
			return WO;
		}
		return null;
	}
}
