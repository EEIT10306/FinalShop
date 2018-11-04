package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreImages;
import model.repository.StoreImagesDao;

@Repository
public class StoreImagesDaoImpl implements StoreImagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreImages> selectAll() throws SQLException {
		List<StoreImages> LSI = getSession().createQuery("from StoreImages", StoreImages.class).list();
		System.out.println(LSI);
		return LSI;
	}

	@Override
	public StoreImages selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		StoreImages SI = getSession().get(StoreImages.class, id);
		System.out.println(SI);
		return SI;
	}

	@Override
	public List<StoreImages> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreImages ";
		hql += hqlString;
		List<StoreImages> LSI = getSession().createQuery(hql, StoreImages.class).list();
		System.out.println(LSI);
		return LSI;
	}

	@Override
	public StoreImages insert(StoreImages bean) throws SQLException {
		StoreImages SI = selectByPk(bean.getsI_id());
		if (SI == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreImages update(StoreImages bean) throws SQLException {
		StoreImages SI = selectByPk(bean.getsI_id());
		if (SI != null) {
			if (bean.getsP_id() != null)
				SI.setsP_id(bean.getsP_id());
			if (bean.getsI_context() != null)
				SI.setsI_context(bean.getsI_context());
			return SI;
		}
		return null;
	}

	public StoreImages update(StoreImages SI, StoreImages bean) throws SQLException {
		if (bean.getsP_id() != null)
			SI.setsP_id(bean.getsP_id());
		if (bean.getsI_context() != null)
			SI.setsI_context(bean.getsI_context());
		return SI;
	}

	@Override
	public Boolean delete(StoreImages bean) throws SQLException {
		StoreImages SI = selectByPk(bean.getsI_id());
		if (SI != null) {
			getSession().delete(SI);
			return true;
		}
		return false;
	}
}
