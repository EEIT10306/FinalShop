package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Groupon;
import model.bean.Images;
import model.bean.State;
import model.bean.Store;
import model.bean.Wish;
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
	public Images selectByPk(Images imagesBean) throws SQLException {
		Images images = getSession().get(Images.class, imagesBean.getId());
		if (images != null) {
			return images;
		}
		return null;
	}

	@Override
	public Images insert(Images imagesBean) throws SQLException {
		Images img = getSession().get(Images.class, imagesBean.getId());
		if (img == null) {
			getSession().save(imagesBean);
			return imagesBean;
		}
		return null;
	}

	@Override
	public Images update(Images imagesBean) throws SQLException {
		Images images = getSession().get(Images.class, imagesBean.getId());
		if (images != null) {
			if ((imagesBean.getFrom().equals("Wish") && getSession().get(Wish.class, imagesBean.getWgsID()) != null)
					|| (imagesBean.getFrom().equals("Store")
							&& getSession().get(Store.class, imagesBean.getWgsID()) != null)
					|| (imagesBean.getFrom().equals("Groupon")
							&& getSession().get(Groupon.class, imagesBean.getWgsID()) != null)) {
				if (getSession().get(State.class, imagesBean.getState()) != null) {
					images.setWgsID(imagesBean.getWgsID());
					images.setCont(imagesBean.getCont());
					images.setFrom(imagesBean.getFrom());
					images.setState(imagesBean.getState());
					return images;
				}
			}
		}
		return null;
	}

	@Override
	public Boolean delete(Images imagesBean) throws SQLException {
		Images images = getSession().get(Images.class, imagesBean.getId());
		if (images != null) {
			getSession().delete(images);
			return true;
		}
		return false;
	}
}
