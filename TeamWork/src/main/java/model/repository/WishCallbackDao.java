package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishCallback;

public interface WishCallbackDao {
	public List<WishCallback> selectAll() throws SQLException;

	public WishCallback selectByPk(Integer id) throws SQLException;

	public List<WishCallback> selectHql(String hqlString) throws SQLException;

	public WishCallback insert(WishCallback bean) throws SQLException;

	public WishCallback update(WishCallback bean) throws SQLException;

}
