package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.DistrictType;
import model.bean.Group;
import model.bean.WishMessage;
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
	public List<WishProduct> select() throws SQLException {
		return getSession().createQuery("from WishProduct", WishProduct.class).setMaxResults(50).list();

	}

	@Override
	public WishProduct select(Integer id) throws SQLException {
		return getSession().get(WishProduct.class, id);
	}

	@Override
	public WishProduct insert(WishProduct bean) throws SQLException {
		WishProduct simple = getSession().get(WishProduct.class, bean.getId());
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishProduct update(Integer id, Integer wishID, String name, Integer productID, Integer amount,
			Integer priceBottom, Integer priceTop, Date completeTime, Integer state) throws SQLException {
		WishProduct wishProduct = this.getSession().get(WishProduct.class, id);
		if (wishProduct != null) {
			wishProduct.setId(id);
			wishProduct.setWishID(wishID);
			wishProduct.setName(name);
			wishProduct.setProductID(productID);
			wishProduct.setAmount(amount);
			wishProduct.setPriceBottom(priceBottom);
			wishProduct.setPriceTop(priceTop);
			wishProduct.setCompleteTime(completeTime);
			wishProduct.setState(state);
			return wishProduct;
		}
		return null;
	}

}
