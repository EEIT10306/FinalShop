package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreFavorite;

public interface StoreFavoriteDao {
	public List<StoreFavorite> select() throws SQLException;
	public StoreFavorite selectByPk(StoreFavorite bean) throws SQLException;
	public StoreFavorite insert(StoreFavorite bean) throws SQLException;
	public StoreFavorite update(StoreFavorite bean) throws SQLException;
	public boolean delete(StoreFavorite bean) throws SQLException;
}
