package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreOrder;
import model.repository.StoreOrderDao;
@Repository
public class StoreOrderDaoImpl implements StoreOrderDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public List<StoreOrder> select() throws SQLException {
		return this.getSession().createQuery("From StoreOrder", StoreOrder.class).setMaxResults(50).list();
	}

	@Override
	public StoreOrder select(Integer id) throws SQLException {
		return this.getSession().get(StoreOrder.class, id);
	}

	@Override
	public StoreOrder insert(StoreOrder bean) throws SQLException {
		StoreOrder storeOrder = this.getSession().get(StoreOrder.class, bean.getId());
		if(storeOrder == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreOrder update(Integer id, Integer productId, Integer memberStoreIdEE, String storeProductName,
			Integer amount, Integer storeProductPrice, Integer state) throws SQLException {
		StoreOrder storeOrder = this.getSession().get(StoreOrder.class, id);
		if(storeOrder != null) {
			storeOrder.setProductId(productId);
			storeOrder.setMemberStoreIdEE(memberStoreIdEE);
			storeOrder.setStoreProductName(storeProductName);
			storeOrder.setAmount(amount);
			storeOrder.setStoreProductPrice(storeProductPrice);
			storeOrder.setState(state);
			this.getSession().update(storeOrder);
			return storeOrder;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		StoreOrder storeOrder = this.getSession().get(StoreOrder.class, id);
		if(storeOrder != null) {
			this.getSession().delete(storeOrder);
			return true;
		}
		return false;
	}

}
