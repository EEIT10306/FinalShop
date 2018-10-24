package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Product;
import model.repository.ProductDao;

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
	public Product selectByPk(Integer id) throws SQLException {
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
	public Product update(Product bean) throws SQLException {
		Product product = this.getSession().get(Product.class, bean.getId());
		if(product != null) {
			product.setName(bean.getName());
			product.setParentsId(bean.getParentsId());
			product.setStage(bean.getStage());
			return product;
		}
		return null;
	}

}
