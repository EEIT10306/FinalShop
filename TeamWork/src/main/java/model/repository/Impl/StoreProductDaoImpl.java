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
	public List<StoreProduct> select() throws SQLException {
		return this.getSession().createQuery("From StoreProduct", StoreProduct.class).setMaxResults(50).list();
	}

	@Override
	public StoreProduct select(Integer id) throws SQLException {
		return this.getSession().get(StoreProduct.class, id);
	}

	@Override
	public StoreProduct insert(StoreProduct bean) throws SQLException {
		StoreProduct storeProduct = this.getSession().get(StoreProduct.class, bean.getId());
		if(storeProduct == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreProduct update(Integer id, Integer storeId, String name, Integer productId, Integer amount,
			Integer price, Integer state) throws SQLException {
		StoreProduct storeProduct = this.getSession().get(StoreProduct.class, id);
		if(storeProduct != null) {
			storeProduct.setStoreId(storeId);
			storeProduct.setName(name);
			storeProduct.setProductId(productId);
			storeProduct.setAmount(amount);
			storeProduct.setPrice(price);
			storeProduct.setState(state);
			this.getSession().update(storeProduct);
			return storeProduct;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		StoreProduct storeProduct = this.getSession().get(StoreProduct.class, id);
		if(storeProduct != null) {
			this.getSession().delete(storeProduct);
			return true;
		}
		return false;
	}

}
