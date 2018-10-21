package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.GroupProduct;

public interface GroupProductDao {
	public List<GroupProduct> selectAll() throws SQLException;

	public GroupProduct select(Integer id) throws SQLException;

	public GroupProduct insert(GroupProduct groupProduct) throws SQLException;

	public GroupProduct update(Integer id, Integer groupID, String name, Integer prodID, Integer amt, Integer price,
			String cont, Integer ver, Date compTime, Integer gpState) throws SQLException;

	public Boolean delete(Integer id) throws SQLException;
}
