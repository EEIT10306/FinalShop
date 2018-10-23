package model.repository.Impl;

import java.sql.Blob;
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
		return getSession().createQuery("from Images", Images.class).setMaxResults(50).list();
	}

	@Override
	public Images select(Integer id) throws SQLException {
		return getSession().get(Images.class, id);
	}

	@Override
	public Images insert(Images images) throws SQLException {
		Images img = getSession().get(Images.class, images.getId());
		if (img == null) {
			getSession().save(images);
			return images;
		}
		return null;
	}

	@Override
	public Images update(Integer id, Integer wgsID, Blob cont, Integer imState) throws SQLException {
		Images images = getSession().get(Images.class, id);
		if (images != null) {
			images.setId(id);
			images.setWgsID(wgsID);
			images.setCont(cont);
			images.setState(imState);
			getSession().update(images);
			return images;
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		Images images = getSession().get(Images.class, id);
		if (images != null) {
			getSession().delete(images);
			return true;
		}
		return false;
	}
}
