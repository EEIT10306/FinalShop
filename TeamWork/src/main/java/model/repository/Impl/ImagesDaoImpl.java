package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Images;
import model.repository.ImagesDao;

@Repository
public class ImagesDaoImpl implements ImagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Images> selectAll() throws SQLException {
		List<Images> LI = getSession().createQuery("from Images", Images.class).list();
		System.out.println(LI);
		return LI;
	}

	@Override
	public Images selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		Images I = getSession().get(Images.class, id);
		System.out.println(I);
		return I;
	}

	@Override
	public List<Images> selectHql(String hqlString) throws SQLException {
		String hql = "from Images ";
		hql += hqlString;
		List<Images> LI = getSession().createQuery(hql, Images.class).list();
		System.out.println(LI);
		return LI;
	}

	@Override
	public Images insert(Images bean) throws SQLException {
		Images I = selectByPk(bean.getId());
		if (I == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Images update(Images bean) throws SQLException {
		Images I = selectByPk(bean.getId());
		if (I != null) {
			if (bean.getWgsId() != null)
				I.setWgsId(bean.getWgsId());
			if (bean.getContext() != null)
				I.setContext(bean.getContext());
			if (bean.getFrom() != null)
				I.setFrom(bean.getFrom());
			return I;
		}
		return null;
	}

	@Override
	public Boolean delete(Images bean) throws SQLException {
		Images I = selectByPk(bean.getId());
		if (I != null) {
			getSession().delete(I);
			return true;
		}
		return false;
	}
}
