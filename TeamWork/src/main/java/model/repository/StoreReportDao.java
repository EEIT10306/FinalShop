package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreReport;

public interface StoreReportDao {
	public List<StoreReport> select() throws SQLException;
	public StoreReport select(Integer id) throws SQLException;
	public StoreReport insert(StoreReport bean) throws SQLException;
	public StoreReport update(Integer id, String content) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}