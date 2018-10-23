package model.repository;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import model.bean.Store;

public interface StoreDao {
	public List<Store> select() throws SQLException;
	public Store select(Integer id) throws SQLException;
	public Store insert(Store bean) throws SQLException;
	public Store update(Integer id, Integer sellerId, String name, Blob photo, Integer productId, String address, Integer telephone, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
