package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import misc.SpringJavaConfiguration;
import model.bean.Images;
import model.repository.ImagesDao;

@Repository
public class ImagesDaoImpl implements ImagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		ImagesDaoImpl dao = ctx.getBean(ImagesDaoImpl.class);
		dao.getSession().beginTransaction();
		System.out.println(dao.selectAll());
		dao.getSession().getTransaction().commit();
		((ConfigurableApplicationContext) ctx).close();
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
	public Images update(Integer id, Integer wgsID, Byte[] cont, Integer imState) throws SQLException {
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		return false;
	}

}
