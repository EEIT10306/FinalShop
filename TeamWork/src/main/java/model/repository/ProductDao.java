package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Product;

public interface ProductDao {
	public List<Product> select() throws SQLException;
	public Product select(Integer id) throws SQLException;
	public Product insert(Product bean) throws SQLException;
	public Product update(Integer id, String name, Integer parentsId, Integer stage) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
