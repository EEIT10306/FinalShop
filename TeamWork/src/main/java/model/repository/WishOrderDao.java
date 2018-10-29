package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishOrder;

public interface WishOrderDao {
	public List<WishOrder> selectAll() throws SQLException;

	public WishOrder selectByPk(Integer id) throws SQLException;
	
	public List<WishOrder> selectHql(String hqlString) throws SQLException;

	public WishOrder insert(WishOrder bean) throws SQLException;

	public WishOrder update(WishOrder bean) throws SQLException;

}
