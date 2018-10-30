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
		WishBid WB = selectByPk(bean.getId());
		if (WB == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishBid update(WishBid bean) throws SQLException {
		WishBid WB = selectByPk(bean.getId());
		if (WB != null) {
			if (bean.getWishId() != null)
				WB.setWishId(bean.getWishId());
			if (bean.getMemberId() != null)
				WB.setMemberId(bean.getMemberId());
			if (bean.getBid() != null)
				WB.setBid(bean.getBid());
			if (bean.getContext() != null)
				WB.setContext(bean.getContext());
			if (bean.getFreight() != null)
				WB.setFreight(bean.getFreight());
			if (bean.getTime() != null)
				WB.setTime(bean.getTime());
			if (bean.getStateId() != null)
				WB.setStateId(bean.getStateId());
			return WB;
		}
		return null;
	}
}
