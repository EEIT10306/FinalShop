package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishProduct;

public interface WishProductDao {
	public List<WishProduct> selectAll() throws SQLException;

	public WishProduct selectByPk(Integer id) throws SQLException;

	public List<WishProduct> selectHql(String hqlString) throws SQLException;

	public WishProduct insert(WishProduct bean) throws SQLException;

	public WishProduct update(WishProduct bean) throws SQLException;

	public WishProduct update(WishProduct WP, WishProduct bean) throws SQLException;

}
