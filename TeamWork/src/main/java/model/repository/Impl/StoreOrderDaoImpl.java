package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.Product;
import model.bean.State;
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
	public StoreOrder selectByPk(Integer id) throws SQLException {
		return this.getSession().get(StoreOrder.class, id);
	}

	@Override
	public StoreOrder insert(StoreOrder bean) throws SQLException {
		StoreOrder storeOrder = this.getSession().get(StoreOrder.class, bean.getId());
		if(storeOrder == null) {
			Product product = this.getSession().get(Product.class, bean.getProductId());
			Member member = this.getSession().get(Member.class, bean.getMemberStoreIdEE());
			State state = this.getSession().get(State.class, bean.getState());
			if(product != null && member != null && state != null) {
				this.getSession().save(bean);
				return bean;
			}
			return null;
		}
		return null;
	}

	@Override
	public StoreOrder update(StoreOrder bean) throws SQLException {
		StoreOrder storeOrder = this.getSession().get(StoreOrder.class, bean.getId());
		if(storeOrder != null) {
			Product product = this.getSession().get(Product.class, bean.getProductId());
			Member member = this.getSession().get(Member.class, bean.getMemberStoreIdEE());
			State state = this.getSession().get(State.class, bean.getState());
			if(product != null && member != null && state != null) {
				storeOrder.setProductId(bean.getProductId());
				storeOrder.setMemberStoreIdEE(bean.getMemberStoreIdEE());
				storeOrder.setStoreProductName(bean.getStoreProductName());
				storeOrder.setAmount(bean.getAmount());
				storeOrder.setStoreProductPrice(bean.getStoreProductPrice());
				storeOrder.setState(bean.getState());
				return storeOrder;				
			}
			return null;
		}
		return null;
	}
}
