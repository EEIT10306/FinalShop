package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreCallback;

public interface StoreCallbackDao {
	public List<StoreCallback> selectAll() throws SQLException;

	public StoreCallback selectByPk(Integer id) throws SQLException;

	public List<StoreCallback> selectHql(String hqlString) throws SQLException;

	public StoreCallback insert(StoreCallback bean) throws SQLException;

	public StoreCallback update(StoreCallback bean) throws SQLException;

	public StoreCallback update(StoreCallback SC, StoreCallback bean) throws SQLException;

}
