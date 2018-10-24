package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreProduct;

public interface StoreProductDao {
	public List<StoreProduct> select() throws SQLException;
	public StoreProduct selectByPk(Integer id) throws SQLException;
	public StoreProduct insert(StoreProduct bean) throws SQLException;
	public StoreProduct update(StoreProduct bean) throws SQLException;
}
