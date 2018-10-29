package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Wish;
import model.repository.WishDao;

@Repository
public class WishDaoImpl implements WishDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Wish> selectAll() throws SQLException {
		List<Wish> LW = getSession().createQuery("from Wish", Wish.class).list();
		System.out.println(LW);
		return LW;
	}

	@Override
	public Wish selectByPk(Integer id) throws SQLException {
		Wish W = getSession().get(Wish.class, id);
		System.out.println(W);
		return W;
	}

	@Override
	public List<Wish> selectHql(String hqlString) throws SQLException {
		String hql = "from Wish ";
		hql += hqlString;
		List<Wish> LW = getSession().createQuery(hql, Wish.class).list();
		System.out.println(LW);
		return LW;
	}

	@Override
	public Wish insert(Wish bean) throws SQLException {
		Wish W = selectByPk(bean.getId());
		if (W == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Wish update(Wish bean) throws SQLException {
		Wish W = selectByPk(bean.getId());
		if (W != null) {
			if (bean.getMemberId() != null)
				W.setMemberId(bean.getMemberId());
			if (bean.getProductId() != null)
				W.setProductId(bean.getProductId());
			if (bean.getTitle() != null)
				W.setTitle(bean.getTitle());
			if (bean.getContext() != null)
				W.setContext(bean.getContext());
			if (bean.getDistrictTypeId() != null)
				W.setDistrictTypeId(bean.getDistrictTypeId());
			if (bean.getStartDate() != null)
				W.setStartDate(bean.getStartDate());
			if (bean.getEndDate() != null)
				W.setEndDate(bean.getEndDate());
			if (bean.getSumPriceBottom() != null)
				W.setSumPriceBottom(bean.getSumPriceBottom());
			if (bean.getSumPriceTop() != null)
				W.setSumPriceTop(bean.getSumPriceTop());
			if (bean.getChangeTime() != null)
				W.setChangeTime(bean.getChangeTime());
			if (bean.getHot() != null)
				W.setHot(bean.getHot());
			if (bean.getCompleteTime() != null)
				W.setCompleteTime(bean.getCompleteTime());
			if (bean.getStateId() != null)
				W.setStateId(bean.getStateId());
			return W;
		}
		return null;
	}

}
