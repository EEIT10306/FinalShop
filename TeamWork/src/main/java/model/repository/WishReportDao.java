package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishReport;

public interface WishReportDao {
	public List<WishReport> select() throws SQLException;
	public WishReport select(Integer id) throws SQLException;
	public WishReport insert(WishReport bean) throws SQLException;
	public WishReport update(Integer id, String content) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}