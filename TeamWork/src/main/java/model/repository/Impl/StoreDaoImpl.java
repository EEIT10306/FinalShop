package model.repository.Impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Product;
import model.bean.Seller;
import model.bean.State;
import model.bean.Store;
import model.repository.StoreDao;

@Repository
public class StoreDaoImpl implements StoreDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public List<Store> select() throws SQLException {
		return this.getSession().createQuery("From Store",Store.class).setMaxResults(50).list();
	}

	@Override
	public Store selectByPk(Integer id) throws SQLException {
		return this.getSession().get(Store.class, id);
	}

	@Override
	public Store insert(Store bean) throws SQLException {
		Store store = this.getSession().get(Store.class, bean.getId());
		if(store == null) {
			Seller seller = this.getSession().get(Seller.class, bean.getSellerId());
			Product product = this.getSession().get(Product.class, bean.getProductId());
			State state = this.getSession().get(State.class, bean.getState());
			if(seller != null && product != null && state != null){
				this.getSession().save(bean);
				return bean;				
			}
			return null;
		}
		return null;
	}

	@Override
	public Store update(Store bean) throws SQLException {
		Store store = this.getSession().get(Store.class, bean.getId());
		if(store != null) {
			Seller seller = this.getSession().get(Seller.class, bean.getSellerId());
			Product product = this.getSession().get(Product.class, bean.getProductId());
			State state = this.getSession().get(State.class, bean.getState());
			if(seller != null && product != null && state != null) {
				store.setSellerId(bean.getSellerId());
				store.setName(bean.getName());
				store.setPhoto(bean.getPhoto());
				store.setProductId(bean.getProductId());
				store.setAddress(bean.getAddress());
				store.setTelephone(bean.getTelephone());
				store.setState(bean.getState());
				return store;
			}
			return null;
		}
		return null;
	}

}
