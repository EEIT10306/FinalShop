package model.repository.Impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public Store select(Integer id) throws SQLException {
		return this.getSession().get(Store.class, id);
	}

	@Override
	public Store insert(Store bean) throws SQLException {
		Store store = this.getSession().get(Store.class, bean.getId());
		if(store == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Store update(Integer id, Integer sellerId, String name, Blob photo, Integer productId, String address,
			Integer telephone, Integer state) throws SQLException {
		Store store = this.getSession().get(Store.class, id);
		if(store != null) {
			store.setId(id);
			store.setSellerId(sellerId);
			store.setName(name);
			store.setPhoto(photo);
			store.setProductId(productId);
			store.setAddress(address);
			store.setTelephone(telephone);
			store.setState(state);
			this.getSession().update(store);
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Store store = this.getSession().get(Store.class, id);
		if(store != null) {
			this.getSession().delete(store);
		}
		return false;
	}

}
