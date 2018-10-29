package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishBid;

public interface WishBidDao {
	public List<WishBid> selectAll() throws SQLException;

	public WishBid selectByPk(Integer id) throws SQLException;

	public List<WishBid> selectHql(String hqlString) throws SQLException;

	public WishBid insert(WishBid bean) throws SQLException;

	public WishBid update(WishBid bean) throws SQLException;

}
