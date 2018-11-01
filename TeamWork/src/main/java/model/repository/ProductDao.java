package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Product;

public interface ProductDao {
	public List<Product> selectAll() throws SQLException;

	public Product selectByPk(Integer id) throws SQLException;

	public List<Product> selectHql(String hqlString) throws SQLException;

	public Product insert(Product bean) throws SQLException;

	public Product update(Product bean) throws SQLException;

	public Product update(Product P, Product bean) throws SQLException;

}
