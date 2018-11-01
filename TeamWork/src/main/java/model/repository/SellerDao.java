package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Seller;

public interface SellerDao {
	public List<Seller> selectAll() throws SQLException;

	public Seller selectByPk(Integer id) throws SQLException;

	public List<Seller> selectHql(String hqlString) throws SQLException;

	public Seller insert(Seller bean) throws SQLException;

	public Seller update(Seller bean) throws SQLException;
	
	public Seller update(Seller S, Seller bean) throws SQLException;

}
