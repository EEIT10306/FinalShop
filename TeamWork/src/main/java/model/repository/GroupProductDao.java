package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupProduct;

public interface GroupProductDao {
	public List<GroupProduct> selectAll() throws SQLException;

	public GroupProduct selectByPk(GroupProduct groupProductBean) throws SQLException;

	public GroupProduct insert(GroupProduct groupProductBean) throws SQLException;

	public GroupProduct update(GroupProduct groupProductBean) throws SQLException;
}
