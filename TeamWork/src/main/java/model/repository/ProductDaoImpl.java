package model.repository;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Product;
import model.repository.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public List<Product> select() throws SQLException {		
		return this.getSession().createQuery("From Product", Product.class).setMaxResults(50).list();
	}

	@Override
	public Product select(Integer id) throws SQLException {
		return this.getSession().get(Product.class, id);
	}

	@Override
	public Product insert(Product bean) throws SQLException {
		 Product product = this.getSession().get(Product.class, bean.getId());
		 if(product == null) {
			 getSession().save(bean);
			 return bean;
		 }
		 return null;
	}

	@Override
	public Product update(Integer id, String name, Integer parentsId, Integer stage) throws SQLException {
		Product product = this.getSession().get(Product.class, id);
		if(product != null) {
			product.setId(id);
			product.setName(name);
			product.setParentsId(parentsId);
			product.setStage(stage);;
			getSession().update(product);
			return product;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Product product = this.getSession().get(Product.class, id);
		if(product != null) {
			getSession().delete(product);
			return true;
		}
		return false;
	}

}
