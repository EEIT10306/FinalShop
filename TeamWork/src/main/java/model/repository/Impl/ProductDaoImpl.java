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
	public List<Product> selectAll() throws SQLException {
		List<Product> LP = getSession().createQuery("From Product", Product.class).list();
		System.out.println(LP);
		return LP;
	}

	@Override
	public Product selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		Product P = getSession().get(Product.class, id);
		System.out.println(P);
		return P;
	}

	@Override
	public List<Product> selectHql(String hqlString) throws SQLException {
		String hql = "from Product ";
		hql += hqlString;
		List<Product> LP = getSession().createQuery(hql, Product.class).list();
		System.out.println(LP);
		return LP;
	}

	@Override
	public Product insert(Product bean) throws SQLException {
		Product P = selectByPk(bean.getP_id());
		if (P == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Product update(Product bean) throws SQLException {
		Product P = selectByPk(bean.getP_id());
		if (P != null) {
			if (bean.getP_name() != null)
				P.setP_name(bean.getP_name());
			if (bean.getP_parentsId() != null)
				P.setP_parentsId(bean.getP_parentsId());
			if (bean.getP_stage() != null)
				P.setP_stage(bean.getP_stage());
			return P;
		}
		return null;
	}

}
