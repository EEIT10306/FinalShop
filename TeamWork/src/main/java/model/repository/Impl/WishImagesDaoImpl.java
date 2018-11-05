package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishImages;
import model.repository.WishImagesDao;

@Repository
public class WishImagesDaoImpl implements WishImagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishImages> selectAll() throws SQLException {
		List<WishImages> LWI = getSession().createQuery("from WishImages", WishImages.class).list();
		System.out.println(LWI);
		return LWI;
	}

	@Override
	public WishImages selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		WishImages WI = getSession().get(WishImages.class, id);
		System.out.println(WI);
		return WI;
	}

	@Override
	public List<WishImages> selectHql(String hqlString) throws SQLException {
		String hql = "from WishImages ";
		hql += hqlString;
		List<WishImages> LWI = getSession().createQuery(hql, WishImages.class).list();
		System.out.println(LWI);
		return LWI;
	}

	@Override
	public WishImages insert(WishImages bean) throws SQLException {
		WishImages WI = selectByPk(bean.getwI_id());
		if (WI == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishImages update(WishImages bean) throws SQLException {
		WishImages WI = selectByPk(bean.getwI_id());
		if (WI != null) {
			if (bean.getwP_id() != null)
				WI.setwP_id(bean.getwP_id());
			if (bean.getwI_context() != null)
				WI.setwI_context(bean.getwI_context());
			return WI;
		}
		return null;
	}

	public WishImages update(WishImages WI, WishImages bean) throws SQLException {
		if (bean.getwP_id() != null)
			WI.setwP_id(bean.getwP_id());
		if (bean.getwI_context() != null)
			WI.setwI_context(bean.getwI_context());
		return WI;
	}

	@Override
	public Boolean delete(WishImages bean) throws SQLException {
		WishImages WI = selectByPk(bean.getwI_id());
		if (WI != null) {
			getSession().delete(WI);
			return true;
		}
		return false;
	}
}
