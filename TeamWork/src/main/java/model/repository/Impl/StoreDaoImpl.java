package model.repository.Impl;

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
	public List<Store> selectAll() throws SQLException {
		List<Store> LS = getSession().createQuery("From Store", Store.class).list();
		System.out.println(LS);
		return LS;
	}

	@Override
	public Store selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		Store S = getSession().get(Store.class, id);
		System.out.println(S);
		return S;
	}

	@Override
	public List<Store> selectHql(String hqlString) throws SQLException {
		String hql = "from Store ";
		hql += hqlString;
		List<Store> LS = getSession().createQuery(hql, Store.class).list();
		System.out.println(LS);
		return LS;
	}

	@Override
	public Store insert(Store bean) throws SQLException {
		Store S = selectByPk(bean.getId());
		if (S == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Store update(Store bean) throws SQLException {
		Store S = selectByPk(bean.getId());
		if (S != null) {
			if (bean.getSellerId() != null)
				S.setSellerId(bean.getSellerId());
			if (bean.getName() != null)
				S.setName(bean.getName());
			if (bean.getPhoto() != null)
				S.setPhoto(bean.getPhoto());
			if (bean.getContext() != null)
				S.setContext(bean.getContext());
			if (bean.getProductId() != null)
				S.setProductId(bean.getProductId());
			if (bean.getAddress() != null)
				S.setAddress(bean.getAddress());
			if (bean.getTelephone() != null)
				S.setTelephone(bean.getTelephone());
			if (bean.getWeb() != null)
				S.setWeb(bean.getWeb());
			if (bean.getStateId() != null)
				S.setStateId(bean.getStateId());
			return S;
		}
		return null;
	}

}
