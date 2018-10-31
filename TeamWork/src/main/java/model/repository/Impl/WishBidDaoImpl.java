package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishBid;
import model.repository.WishBidDao;

@Repository
public class WishBidDaoImpl implements WishBidDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishBid> selectAll() throws SQLException {
		List<WishBid> LWB = getSession().createQuery("from WishBid", WishBid.class).list();
		System.out.println(LWB);
		return LWB;
	}

	@Override
	public WishBid selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		WishBid WB = getSession().get(WishBid.class, id);
		System.out.println(WB);
		return WB;
	}

	@Override
	public List<WishBid> selectHql(String hqlString) throws SQLException {
		String hql = "from WishBid ";
		hql += hqlString;
		List<WishBid> LWB = getSession().createQuery(hql, WishBid.class).list();
		System.out.println(LWB);
		return LWB;
	}

	@Override
	public WishBid insert(WishBid bean) throws SQLException {
		WishBid WB = selectByPk(bean.getwB_id());
		if (WB == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishBid update(WishBid bean) throws SQLException {
		WishBid WB = selectByPk(bean.getwB_id());
		if (WB != null) {
			if (bean.getW_id() != null)
				WB.setW_id(bean.getW_id());
			if (bean.getM_idBid() != null)
				WB.setM_idBid(bean.getM_idBid());
			if (bean.getwB_bid() != null)
				WB.setwB_bid(bean.getwB_bid());
			if (bean.getwB_context() != null)
				WB.setwB_context(bean.getwB_context());
			if (bean.getwB_freight() != null)
				WB.setwB_freight(bean.getwB_freight());
			if (bean.getwB_time() != null)
				WB.setwB_time(bean.getwB_time());
			if (bean.getwB_stateId() != null)
				WB.setwB_stateId(bean.getwB_stateId());
			return WB;
		}
		return null;
	}
}
