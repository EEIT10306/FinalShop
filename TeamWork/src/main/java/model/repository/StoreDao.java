package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Store;

public interface StoreDao {
	public List<Store> select() throws SQLException;
	public Store selectByPk(Integer id) throws SQLException;
	public Store insert(Store bean) throws SQLException;
	public Store update(Store bean) throws SQLException;
}
