package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Product;
import model.bean.State;
import model.bean.Store;
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
		if (id != null)
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
		StoreProduct SP = selectByPk(bean.getId());
		if (SP == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreProduct update(StoreProduct bean) throws SQLException {
		StoreProduct SP = selectByPk(bean.getId());
		if (SP != null) {
			if (bean.getStoreId() != null)
				SP.setStoreId(bean.getStoreId());
			if (bean.getName() != null)
				SP.setName(bean.getName());
			if (bean.getProductId() != null)
				SP.setProductId(bean.getProductId());
			if (bean.getAmount() != null)
				SP.setAmount(bean.getAmount());
			if (bean.getPrice() != null)
				SP.setPrice(bean.getPrice());
			if (bean.getHot() != null)
				SP.setHot(bean.getHot());
			if (bean.getStateId() != null)
				SP.setStateId(bean.getStateId());
			return SP;
		}
		return null;
	}
}
