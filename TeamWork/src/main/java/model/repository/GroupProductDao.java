package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupProduct;

public interface GroupProductDao {
	public List<GroupProduct> selectAll() throws SQLException;

	public GroupProduct selectByPk(Integer id) throws SQLException;

	public List<GroupProduct> selectHql(String hqlString) throws SQLException;

	public GroupProduct insert(GroupProduct bean) throws SQLException;

	public GroupProduct update(GroupProduct bean) throws SQLException;

	public GroupProduct update(GroupProduct GP, GroupProduct bean) throws SQLException;

}
