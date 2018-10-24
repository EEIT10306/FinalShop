package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishFavorite;

public interface WishFavoriteDao {
	public List<WishFavorite> select() throws SQLException;
	public WishFavorite selectByPk(WishFavorite bean) throws SQLException;
	public WishFavorite insert(WishFavorite bean) throws SQLException;
	public WishFavorite update(WishFavorite bean) throws SQLException;
	public boolean delete(WishFavorite bean) throws SQLException;
}
