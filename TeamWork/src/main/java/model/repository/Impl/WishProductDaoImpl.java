package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishProduct;
import model.repository.WishProductDao;

@Repository
public class WishProductDaoImpl implements WishProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishProduct> selectAll() throws SQLException {
		List<WishProduct> LWP = getSession().createQuery("from WishProduct", WishProduct.class).list();
		System.out.println(LWP);
		return LWP;

	}

	@Override
	public WishProduct selectByPk(Integer id) throws SQLException {
		WishProduct WP = getSession().get(WishProduct.class, id);
		System.out.println(WP);
		return WP;
	}

	@Override
	public List<WishProduct> selectHql(String hqlString) throws SQLException {
		String hql = "from WishProduct ";
		hql += hqlString;
		List<WishProduct> LWP = getSession().createQuery(hql, WishProduct.class).list();
		System.out.println(LWP);
		return LWP;
	}

	@Override
	public WishProduct insert(WishProduct bean) throws SQLException {
		WishProduct WP = selectByPk(bean.getId());
		if (WP == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishProduct update(WishProduct bean) throws SQLException {
		WishProduct WP = selectByPk(bean.getId());
		if (WP != null) {
			if (bean.getWishId() != null)
				WP.setWishId(bean.getWishId());
			if (bean.getName() != null)
				WP.setName(bean.getName());
			if (bean.getProductId() != null)
				WP.setProductId(bean.getProductId());
			if (bean.getAmount() != null)
				WP.setAmount(bean.getAmount());
			if (bean.getPriceBottom() != null)
				WP.setPriceBottom(bean.getPriceBottom());
			if (bean.getPriceTop() != null)
				WP.setPriceTop(bean.getPriceTop());
			if (bean.getCompleteTime() != null)
				WP.setCompleteTime(bean.getCompleteTime());
			if (bean.getStateId() != null)
				WP.setStateId(bean.getStateId());
			return WP;
		}
		return null;
	}

	@Override
	public List<WishProduct> search(String search) throws SQLException {
		return getSession().createQuery("from WishProduct WHERE name LIKE '%"+search+"%'", WishProduct.class).setMaxResults(50).list();
		
	}

}
