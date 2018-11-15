package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreFavorite;
import model.bean.WishFavorite;

public interface WishFavoriteDao {
	public List<WishFavorite> selectAll() throws SQLException;

	public WishFavorite selectByPk(Integer id) throws SQLException;

	public List<WishFavorite> selectHql(String hqlString) throws SQLException;

	public WishFavorite insert(WishFavorite bean) throws SQLException;

	public boolean delete(WishFavorite bean) throws SQLException;

}
