package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Seller;

public interface SellerDao {
	public List<Seller> select() throws SQLException;
	public Seller selectByPk(Seller bean) throws SQLException;
	public Seller insert(Seller bean) throws SQLException;
	public Seller update(Seller bean) throws SQLException;
}
