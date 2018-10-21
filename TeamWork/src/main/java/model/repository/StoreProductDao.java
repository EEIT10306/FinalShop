package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreProduct;

public interface StoreProductDao {
	public List<StoreProduct> select() throws SQLException;
	public StoreProduct select(Integer id) throws SQLException;
	public StoreProduct insert(StoreProduct bean) throws SQLException;
	public StoreProduct update(Integer id, Integer storeId, String name, Integer productId, Integer amount, 
			Integer price, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
