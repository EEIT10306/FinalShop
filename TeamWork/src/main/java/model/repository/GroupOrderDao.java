package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupOrder;

public interface GroupOrderDao {
	public List<GroupOrder> selectAll() throws SQLException;

	public GroupOrder selectByPk(Integer id) throws SQLException;
	
	public List<GroupOrder> selectHql(String hqlString) throws SQLException;

	public GroupOrder insert(GroupOrder bean) throws SQLException;

	public GroupOrder update(GroupOrder bean) throws SQLException;

}
