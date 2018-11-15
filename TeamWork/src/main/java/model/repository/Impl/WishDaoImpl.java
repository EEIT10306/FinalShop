package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Wish;
import model.bean.WishProduct;
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
		if (id == null)
			return null;
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
		Wish W = selectByPk(bean.getW_id());
		if (W == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Wish update(Wish bean) throws SQLException {
		Wish W = selectByPk(bean.getW_id());
		if (W != null) {
			if (bean.getM_id() != null)
				W.setM_id(bean.getM_id());
			if (bean.getP_id() != null)
				W.setP_id(bean.getP_id());
			if (bean.getW_title() != null)
				W.setW_title(bean.getW_title());
			if (bean.getW_context() != null)
				W.setW_context(bean.getW_context());
			if (bean.getD_id() != null)
				W.setD_id(bean.getD_id());
			if (bean.getW_startDate() != null)
				W.setW_startDate(bean.getW_startDate());
			if (bean.getW_endDate() != null)
				W.setW_endDate(bean.getW_endDate());
			if (bean.getW_sumPriceBottom() != null)
				W.setW_sumPriceBottom(bean.getW_sumPriceBottom());
			if (bean.getW_sumPriceTop() != null)
				W.setW_sumPriceTop(bean.getW_sumPriceTop());
			if (bean.getW_changeTime() != null)
				W.setW_changeTime(bean.getW_changeTime());
			if (bean.getW_hot() != null)
				W.setW_hot(bean.getW_hot());
			if (bean.getW_amountFavorite() != null)
				W.setW_amountFavorite(bean.getW_amountFavorite());
			if (bean.getW_completeTime() != null)
				W.setW_completeTime(bean.getW_completeTime());
			if (bean.getW_stateId() != null)
				W.setW_stateId(bean.getW_stateId());
			return W;
		}
		return null;
	}

	public Wish update(Wish W, Wish bean) throws SQLException {
		if (bean.getM_id() != null)
			W.setM_id(bean.getM_id());
		if (bean.getP_id() != null)
			W.setP_id(bean.getP_id());
		if (bean.getW_title() != null)
			W.setW_title(bean.getW_title());
		if (bean.getW_context() != null)
			W.setW_context(bean.getW_context());
		if (bean.getD_id() != null)
			W.setD_id(bean.getD_id());
		if (bean.getW_startDate() != null)
			W.setW_startDate(bean.getW_startDate());
		if (bean.getW_endDate() != null)
			W.setW_endDate(bean.getW_endDate());
		if (bean.getW_sumPriceBottom() != null)
			W.setW_sumPriceBottom(bean.getW_sumPriceBottom());
		if (bean.getW_sumPriceTop() != null)
			W.setW_sumPriceTop(bean.getW_sumPriceTop());
		if (bean.getW_changeTime() != null)
			W.setW_changeTime(bean.getW_changeTime());
		if (bean.getW_hot() != null)
			W.setW_hot(bean.getW_hot());
		if (bean.getW_amountFavorite() != null)
			W.setW_amountFavorite(bean.getW_amountFavorite());
		if (bean.getW_completeTime() != null)
			W.setW_completeTime(bean.getW_completeTime());
		if (bean.getW_stateId() != null)
			W.setW_stateId(bean.getW_stateId());
		return W;
	}
}
