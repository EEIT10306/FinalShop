package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishImages;

public interface WishImagesDao {
	public List<WishImages> selectAll() throws SQLException;

	public WishImages selectByPk(Integer id) throws SQLException;

	public List<WishImages> selectHql(String hqlString) throws SQLException;

	public WishImages insert(WishImages bean) throws SQLException;

	public WishImages update(WishImages bean) throws SQLException;

	public WishImages update(WishImages WI, WishImages bean) throws SQLException;

	public Boolean delete(WishImages bean) throws SQLException;
}
