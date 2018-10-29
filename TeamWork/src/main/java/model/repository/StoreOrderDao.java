package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreOrder;

public interface StoreOrderDao {
	public List<StoreOrder> selectAll() throws SQLException;

	public StoreOrder selectByPk(Integer id) throws SQLException;
	
	public List<StoreOrder> selectHql(String hqlString) throws SQLException;

	public StoreOrder insert(StoreOrder bean) throws SQLException;

	public StoreOrder update(StoreOrder bean) throws SQLException;

}
