package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreFavorite;

public interface StoreFavoriteDao {
	public List<StoreFavorite> selectAll() throws SQLException;

	public StoreFavorite selectByPk(Integer id) throws SQLException;

	public List<StoreFavorite> selectHql(String hqlString) throws SQLException;

	public StoreFavorite insert(StoreFavorite bean) throws SQLException;

	public boolean delete(StoreFavorite bean) throws SQLException;

}
