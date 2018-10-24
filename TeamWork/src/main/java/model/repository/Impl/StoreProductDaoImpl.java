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
	public List<StoreProduct> select() throws SQLException {
		return this.getSession().createQuery("From StoreProduct", StoreProduct.class).setMaxResults(50).list();
	}

	@Override
	public StoreProduct selectByPk(Integer id) throws SQLException {
		return this.getSession().get(StoreProduct.class, id);
	}

	@Override
	public StoreProduct insert(StoreProduct bean) throws SQLException {
		StoreProduct storeProduct = this.getSession().get(StoreProduct.class, bean.getId());
		if(storeProduct == null) {
			Store store = this.getSession().get(Store.class, bean.getStoreId());
			Product product = this.getSession().get(Product.class, bean.getProductId());
			State state = this.getSession().get(State.class, bean.getState());
			if(store != null && product != null && state != null) {
				this.getSession().save(bean);
				return bean;				
			}
			return null;
		}
		return null;
	}

	@Override
	public StoreProduct update(StoreProduct bean) throws SQLException {
		StoreProduct storeProduct = this.getSession().get(StoreProduct.class, bean.getId());
		if(storeProduct != null) {
			Store store = this.getSession().get(Store.class, bean.getStoreId());
			Product product = this.getSession().get(Product.class, bean.getProductId());
			State state = this.getSession().get(State.class, bean.getState());
			if(store != null && product != null && state != null) {
				storeProduct.setStoreId(bean.getStoreId());
				storeProduct.setName(bean.getName());
				storeProduct.setProductId(bean.getProductId());
				storeProduct.setAmount(bean.getAmount());
				storeProduct.setPrice(bean.getPrice());
				storeProduct.setState(bean.getState());
				return storeProduct;				
			}
			return null;
		}
		return null;
	}
}
