package model.repository;


import java.sql.SQLException;
import java.util.List;

import model.bean.Seller;

public interface SellerDao {
	public List<Seller> select() throws SQLException;
	public Seller select(Integer id) throws SQLException;
	public Seller insert(Seller bean) throws SQLException;
	public Seller update(Integer id, Integer memberId, String idCard, String mailVerification, Integer state) throws SQLException;
}
