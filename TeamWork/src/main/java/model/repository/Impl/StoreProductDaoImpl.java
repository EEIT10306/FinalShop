package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreProduct;
import model.repository.StoreProductDao;

@Repository
public class StoreProductDaoImpl implements StoreProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreProduct> selectAll() throws SQLException {
		List<StoreProduct> LSP = getSession().createQuery("From StoreProduct", StoreProduct.class).list();
		System.out.println(LSP);
		return LSP;
	}

	@Override
	public StoreProduct selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		StoreProduct SP = getSession().get(StoreProduct.class, id);
		System.out.println(SP);
		return SP;
	}

	@Override
	public List<StoreProduct> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreProduct ";
		hql += hqlString;
		List<StoreProduct> LSP = getSession().createQuery(hql, StoreProduct.class).list();
		System.out.println(LSP);
		return LSP;
	}

	@Override
	public StoreProduct insert(StoreProduct bean) throws SQLException {
		StoreProduct SP = selectByPk(bean.getsP_id());
		if (SP == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreProduct update(StoreProduct bean) throws SQLException {
		StoreProduct SP = selectByPk(bean.getsP_id());
		if (SP != null) {
			if (bean.getsP_id() != null)
				SP.setsP_id(bean.getsP_id());
			if (bean.getS_id() != null)
				SP.setS_id(bean.getS_id());
			if (bean.getsP_name() != null)
				SP.setsP_name(bean.getsP_name());
			if (bean.getsP_context() != null)
				SP.setsP_context(bean.getsP_context());
			if (bean.getP_id() != null)
				SP.setP_id(bean.getP_id());
			if (bean.getsP_amount() != null)
				SP.setsP_amount(bean.getsP_amount());
			if (bean.getsP_price() != null)
				SP.setsP_price(bean.getsP_price());
			if (bean.getsP_hot() != null)
				SP.setsP_hot(bean.getsP_hot());
			if (bean.getsP_amountFavorite() != null)
				SP.setsP_amountFavorite(bean.getsP_amountFavorite());
			if (bean.getsP_averageAssess() != null)
				SP.setsP_averageAssess(bean.getsP_averageAssess());
			if (bean.getsP_amountAssess() != null)
				SP.setsP_amountAssess(bean.getsP_amountAssess());
			if (bean.getsP_stateId() != null)
				SP.setsP_stateId(bean.getsP_stateId());
			return SP;
		}
		return null;
	}

	public StoreProduct update(StoreProduct SP, StoreProduct bean) throws SQLException {
		if (bean.getsP_id() != null)
			SP.setsP_id(bean.getsP_id());
		if (bean.getS_id() != null)
			SP.setS_id(bean.getS_id());
		if (bean.getsP_name() != null)
			SP.setsP_name(bean.getsP_name());
		if (bean.getsP_context() != null)
			SP.setsP_context(bean.getsP_context());
		if (bean.getP_id() != null)
			SP.setP_id(bean.getP_id());
		if (bean.getsP_amount() != null)
			SP.setsP_amount(bean.getsP_amount());
		if (bean.getsP_price() != null)
			SP.setsP_price(bean.getsP_price());
		if (bean.getsP_hot() != null)
			SP.setsP_hot(bean.getsP_hot());
		if (bean.getsP_amountFavorite() != null)
			SP.setsP_amountFavorite(bean.getsP_amountFavorite());
		if (bean.getsP_averageAssess() != null)
			SP.setsP_averageAssess(bean.getsP_averageAssess());
		if (bean.getsP_amountAssess() != null)
			SP.setsP_amountAssess(bean.getsP_amountAssess());
		if (bean.getsP_stateId() != null)
			SP.setsP_stateId(bean.getsP_stateId());
		return SP;
	}
}
