package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishFavorite;

public interface WishFavoriteDao {
	public List<WishFavorite> select() throws SQLException;
	public WishFavorite select(Integer id) throws SQLException;
	public WishFavorite insert(WishFavorite bean) throws SQLException;
	public WishFavorite update(Integer id, Integer memberId, Integer wishProductId) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
