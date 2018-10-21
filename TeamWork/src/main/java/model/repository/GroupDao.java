package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.Group;

public interface GroupDao {
	public List<Group> select() throws SQLException;
	public Group select(Integer id) throws SQLException;
	public Group insert(Group bean) throws SQLException;
	public Group update(Integer id, Integer memberId, Integer groupClass, String title, String cont, Integer districtTypeId,
			Date startDate, Date endDate, String goal, Date compTime, Integer state) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
