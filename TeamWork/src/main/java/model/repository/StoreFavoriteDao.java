package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreFavorite;

public interface StoreFavoriteDao {
	public List<StoreFavorite> select() throws SQLException;
	public StoreFavorite select(Integer id) throws SQLException;
	public StoreFavorite insert(StoreFavorite bean) throws SQLException;
	public StoreFavorite update(Integer id, Integer memberId, Integer storeProductId) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
