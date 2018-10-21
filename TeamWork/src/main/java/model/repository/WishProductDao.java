package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.WishProduct;

public interface WishProductDao {
	public List<WishProduct> select() throws SQLException;
	public WishProduct select(Integer id) throws SQLException;
	public WishProduct insert(WishProduct bean) throws SQLException;
	public WishProduct update(Integer id, Integer wishId, String name, Integer productId, Integer amount, Integer priceBot,
			Integer priceTop, Date compTime, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
