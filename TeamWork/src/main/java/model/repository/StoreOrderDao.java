package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreOrder;

public interface StoreOrderDao {
	public List<StoreOrder> select() throws SQLException;
	public StoreOrder select(Integer id) throws SQLException;
	public StoreOrder insert(StoreOrder bean) throws SQLException;
	public StoreOrder update(Integer id, Integer productId, Integer memberStoreIDee, String storeProductName,
			Integer amount, Integer storeProductPrice, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
