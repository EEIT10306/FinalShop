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
		if (id == null)
			return null;
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
		WishProduct WP = selectByPk(bean.getwP_id());
		if (WP == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishProduct update(WishProduct bean) throws SQLException {
		WishProduct WP = selectByPk(bean.getwP_id());
		if (WP != null) {
			if (bean.getW_id() != null)
				WP.setW_id(bean.getW_id());
			if (bean.getwP_name() != null)
				WP.setwP_name(bean.getwP_name());
			if (bean.getP_id() != null)
				WP.setP_id(bean.getP_id());
			if (bean.getwP_amount() != null)
				WP.setwP_amount(bean.getwP_amount());
			if (bean.getwP_priceBottom() != null)
				WP.setwP_priceBottom(bean.getwP_priceBottom());
			if (bean.getwP_priceTop() != null)
				WP.setwP_priceTop(bean.getwP_priceTop());
			if (bean.getwP_completeTime() != null)
				WP.setwP_completeTime(bean.getwP_completeTime());
			if (bean.getwP_stateId() != null)
				WP.setwP_stateId(bean.getwP_stateId());
			return WP;
		}
		return null;
	}

}
