package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreReport;

public interface StoreReportDao {
	public List<StoreReport> select() throws SQLException;
	public StoreReport selectByPk(StoreReport bean) throws SQLException;
	public StoreReport insert(StoreReport bean) throws SQLException;
	public StoreReport update(StoreReport bean) throws SQLException;
	
}