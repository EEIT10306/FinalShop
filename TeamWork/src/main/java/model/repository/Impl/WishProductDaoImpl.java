package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Product;
import model.bean.State;
import model.bean.Wish;
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
			Wish wish = getSession().get(Wish.class, bean.getId());
			Product pro= getSession().get(Product.class, bean.getId());
			State sta = getSession().get(State.class, bean.getState());
			if(wish!=null&& pro!=null&&sta!=null) {
				
				getSession().save(bean);
				return bean;
			}
			return null;
		}
		return null;
	}
	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product productBean;

	
	@Override
	public WishProduct update(WishProduct bean) throws SQLException {
		WishProduct wishProduct = this.getSession().get(WishProduct.class, bean.getId());
		if (wishProduct != null) {
			Wish wish = getSession().get(Wish.class, bean.getId());
			Product pro= getSession().get(Product.class, bean.getId());
			State sta = getSession().get(State.class, bean.getState());
			if(wish!=null&& pro!=null&&sta!=null) {			
				wishProduct.setWishID(bean.getWishID());
				wishProduct.setName(bean.getName());
				wishProduct.setProductID(bean.getProductID());
				wishProduct.setAmount(bean.getAmount());
				wishProduct.setPriceBottom(bean.getPriceBottom());
				wishProduct.setPriceTop(bean.getPriceTop());
				wishProduct.setCompleteTime(bean.getCompleteTime());
				wishProduct.setState(bean.getState());
				return wishProduct;
			}
			return null;
		}
		return null;
	}

}
