package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreAssess;

public interface StoreAssessDao {
	public List<StoreAssess> selectAll() throws SQLException;

	public StoreAssess selectByPk(Integer id) throws SQLException;

	public List<StoreAssess> selectHql(String hqlString) throws SQLException;

	public StoreAssess insert(StoreAssess bean) throws SQLException;

	public StoreAssess update(StoreAssess bean) throws SQLException;

	public StoreAssess update(StoreAssess SA, StoreAssess bean) throws SQLException;

}