package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreReport;

public interface StoreReportDao {
	public List<StoreReport> selectAll() throws SQLException;

	public StoreReport selectByPk(Integer id) throws SQLException;

	public List<StoreReport> selectHql(String hqlString) throws SQLException;

	public StoreReport insert(StoreReport bean) throws SQLException;

	public StoreReport update(StoreReport bean) throws SQLException;

}