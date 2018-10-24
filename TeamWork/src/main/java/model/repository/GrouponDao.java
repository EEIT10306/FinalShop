package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.Group;
import model.bean.Groupon;

public interface GrouponDao {
	public List<Groupon> select() throws SQLException;
	public Groupon select(Integer id) throws SQLException;
	public Groupon insert(Groupon bean) throws SQLException;
	public Groupon update(Integer id, Integer memberId, Integer groupClass, String title, String cont, Integer districtTypeId,
			Date startDate, Date endDate, String goal, Date compTime, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
