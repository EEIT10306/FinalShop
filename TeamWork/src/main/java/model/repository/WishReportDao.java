package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishReport;

public interface WishReportDao {
	public List<WishReport> selectAll() throws SQLException;

	public WishReport selectByPk(Integer id) throws SQLException;

	public List<WishReport> selectHql(String hqlString) throws SQLException;

	public WishReport insert(WishReport bean) throws SQLException;

	public WishReport update(WishReport bean) throws SQLException;

	public WishReport update(WishReport WR, WishReport bean) throws SQLException;

}