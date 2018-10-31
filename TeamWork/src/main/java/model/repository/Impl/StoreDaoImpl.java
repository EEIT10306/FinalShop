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
		if (id == null)
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
		Store S = selectByPk(bean.getS_id());
		if (S == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Store update(Store bean) throws SQLException {
		Store S = selectByPk(bean.getS_id());
		if (S != null) {
			if (bean.getSeller_id() != null)
				S.setSeller_id(bean.getSeller_id());
			if (bean.getS_name() != null)
				S.setS_name(bean.getS_name());
			if (bean.getS_photo() != null)
				S.setS_photo(bean.getS_photo());
			if (bean.getS_context() != null)
				S.setS_context(bean.getS_context());
			if (bean.getP_id() != null)
				S.setP_id(bean.getP_id());
			if (bean.getS_address() != null)
				S.setS_address(bean.getS_address());
			if (bean.getS_telephone() != null)
				S.setS_telephone(bean.getS_telephone());
			if (bean.getS_web() != null)
				S.setS_web(bean.getS_web());
			if (bean.getS_stateId() != null)
				S.setS_stateId(bean.getS_stateId());
			return S;
		}
		return null;
	}

	public Store update(Store S, Store bean) throws SQLException {
		if (bean.getSeller_id() != null)
			S.setSeller_id(bean.getSeller_id());
		if (bean.getS_name() != null)
			S.setS_name(bean.getS_name());
		if (bean.getS_photo() != null)
			S.setS_photo(bean.getS_photo());
		if (bean.getS_context() != null)
			S.setS_context(bean.getS_context());
		if (bean.getP_id() != null)
			S.setP_id(bean.getP_id());
		if (bean.getS_address() != null)
			S.setS_address(bean.getS_address());
		if (bean.getS_telephone() != null)
			S.setS_telephone(bean.getS_telephone());
		if (bean.getS_web() != null)
			S.setS_web(bean.getS_web());
		if (bean.getS_stateId() != null)
			S.setS_stateId(bean.getS_stateId());
		return S;
	}

}
