package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.Wish;

public interface WishDao {
	public List<Wish> select() throws SQLException;
	public Wish select(Integer id) throws SQLException;
	public Wish insert(Wish bean) throws SQLException;
	public Wish update(Integer id, Integer memberId, Integer productId, String title, String cont, Integer districtTypeId,
			Date startDate, Date endDate, Date compTime, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
