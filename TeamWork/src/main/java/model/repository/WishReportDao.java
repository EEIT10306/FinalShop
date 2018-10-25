package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishReport;

public interface WishReportDao {
	public List<WishReport> select() throws SQLException;
	public WishReport selectByPk(WishReport bean) throws SQLException;
	public WishReport insert(WishReport bean) throws SQLException;
	public WishReport update(WishReport bean) throws SQLException;
}